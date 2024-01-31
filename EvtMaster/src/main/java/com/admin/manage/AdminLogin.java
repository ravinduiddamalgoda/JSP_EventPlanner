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


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		
		isTrue = Admin_DBUtill.validateAdmin(userName, password);
		
		if(isTrue) {
			session.setAttribute("adminUserName", userName);
			ArrayList<Event> er = Admin_DBUtill.getUnverifiedEvent();
			
			request.setAttribute("event", er);
			
			RequestDispatcher dis =  request.getRequestDispatcher("AdminMain.jsp");
			dis.forward(request, response);
			out.print("<script type = 'text/javascript'>");
			out.print("location='AdminMain.jsp'");
			out.print("</script>");
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your username or Password is incorrect!!');");
			out.println("location='AdminLogin.jsp'");
			out.println("</script>");
			
		}
		
		
		
	}

}
