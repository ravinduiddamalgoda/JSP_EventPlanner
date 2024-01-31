package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int age =  Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno =  request.getParameter("phoneno");
		
		boolean result = false;
		result = UserDBUtill.registerUser(userName, password, age, name, email, phoneno);
		
		if(result) {
			RequestDispatcher dis =  request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Ecounting Error');");
			out.println("location='RegisterUser.jsp'");
			out.println("</script>");
		}
		
		
		
	}

}
