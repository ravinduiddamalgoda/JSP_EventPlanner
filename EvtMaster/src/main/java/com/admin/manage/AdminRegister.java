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

import com.event.EP_DBUtill;
import com.event.Event;


@WebServlet("/AdminRegister")
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String adminPhoneno = request.getParameter("adminPhoneno");
		
		boolean stat = false;

		boolean validUN =  Admin_DBUtill.checkUserName(userName);
		if(validUN) {
			stat = Admin_DBUtill.registerAdmin(userName, password, email, adminPhoneno);
			
			if (stat) {
				ArrayList<Event> er = Admin_DBUtill.getUnverifiedEvent();
				request.setAttribute("event", er);
				RequestDispatcher dis =  request.getRequestDispatcher("AdminMain.jsp");
				dis.forward(request, response);
				out.println("<script type = 'text/javascript'>");
				out.println("alert('Registration Success!!');");
				out.println("location='AdminRegister.jsp'");
				out.println("</script>");
			}else {
				out.println("<script type = 'text/javascript'>");
				out.println("alert('Registration Error!!');");
				out.println("location='AdminRegister.jsp'");
				out.println("</script>");
				
			}
			
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('User Name already Taken!!');");
			out.println("location='AdminRegister.jsp'");
			out.println("</script>");
			
		}
		
	}

}
