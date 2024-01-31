package com.admin.manage;

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




@WebServlet("/VerifyEvent")
public class VerifyEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String EventID = request.getParameter("eventID");
		int evtID =  Integer.parseInt(EventID);
		String adminUserName = (String) session.getAttribute("adminUserName");
		int adminID = Admin_DBUtill.getAdminID(adminUserName);
		boolean stat = Admin_DBUtill.verifyEvent(adminID, evtID);
		if(stat) {
			request.setAttribute("successMessage", "Registration was successful!");
			ArrayList<Event> er = Admin_DBUtill.getUnverifiedEvent();
			request.setAttribute("event", er);
			RequestDispatcher dis =  request.getRequestDispatcher("AdminMain.jsp");
			dis.forward(request, response);
			
			
		}else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Update Error!!');");
			out.println("</script>");
			ArrayList<Event> er = Admin_DBUtill.getUnverifiedEvent();
			request.setAttribute("event", er);
			RequestDispatcher dis =  request.getRequestDispatcher("AdminMain.jsp");
			dis.forward(request, response);
			
		}
	
	}

}
