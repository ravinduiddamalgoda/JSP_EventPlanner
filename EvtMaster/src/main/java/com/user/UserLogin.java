package com.user;

import com.event.*;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
//	HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		
		isTrue = UserDBUtill.validateUserData(userName, password);
		
		if(isTrue) {
			
//			ArrayList<User> users =  new ArrayList();
			ArrayList<User> users = (ArrayList<User>) UserDBUtill.getSpecificCustomer(userName);
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
			out.println("alert('Your username or Password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
		
		
		
		
		
	}

}
