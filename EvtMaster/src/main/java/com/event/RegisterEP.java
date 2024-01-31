package com.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterEP")
public class RegisterEP extends HttpServlet {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String companyName = request.getParameter("companyName");
		
		boolean stat = false;

		boolean validUN =  EP_DBUtill.checkUserName(userName);
		if(validUN) {
			stat = EP_DBUtill.registerEVP(userName, password, name , email , companyName);
			
			if (stat) {
				RequestDispatcher dis =  request.getRequestDispatcher("EventPlannerLogin.jsp");
				dis.forward(request, response);
			}else {
				out.println("<script type = 'text/javascript'>");
				out.println("alert('Registration Error!!');");
				out.println("location='EP_Register.jsp'");
				out.println("</script>");
				
			}
			
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('User Name already Taken!!');");
			out.println("location='EP_Register.jsp'");
			out.println("</script>");
			
		}
		
	}

}
