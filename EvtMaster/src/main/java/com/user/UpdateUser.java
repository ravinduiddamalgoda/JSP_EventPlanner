package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.event.Event;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userID =  (String) session.getAttribute("userID");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String emailString = request.getParameter("email");
		String phoneNo =  request.getParameter("phoneno");
		
		boolean status =  UserDBUtill.UpdateData(userID, name, emailString, age, phoneNo);
		
		if(status) {
			
			ArrayList<User> users = (ArrayList<User>) UserDBUtill.getSpecificUserByID(userID);
			request.setAttribute("User", users);
			for(User u : users) {
				int uid = u.getUserID();
				String uIDStr = Integer.toString(uid);
				session.setAttribute("userID", uIDStr);
			}
			ArrayList<Event> eventList = UserDBUtill.getEvent();
			request.setAttribute("eventList", eventList);
			RequestDispatcher dis =  request.getRequestDispatcher("TicketBook.jsp");
			dis.forward(request, response);
		}else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error Occured!!');");
			out.println("location='account.jsp'");
			out.println("</script>");
		}
		
		
		
	}

}
