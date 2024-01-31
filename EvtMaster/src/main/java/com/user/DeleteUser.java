package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String userID = request.getParameter("userID");
		boolean status = false;
		status = UserDBUtill.DeleteUser(userID);
		
		if(status) {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('User Deleted Succesflly!!');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error Occured!!');");
			out.println("location='acount.jsp'");
			out.println("</script>");
		}
		
	}

}
