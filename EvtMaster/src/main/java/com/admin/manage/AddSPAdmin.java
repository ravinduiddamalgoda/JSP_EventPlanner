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

import com.event.Event;


@WebServlet("/AddSPAdmin")
public class AddSPAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		String company = request.getParameter("company"); 
		String serviceDescription = request.getParameter("service_description");
		String phoneNo = request.getParameter("phone_no"); 
		
		boolean userNameunExist =  Admin_DBUtill.ValidServiceProviderUserName(username);
		
		if(userNameunExist) {
			
			boolean status = Admin_DBUtill.addServiceProvider(username, password, name, email, company, serviceDescription, phoneNo);
			
			if(status) {
				ArrayList<Event> er = Admin_DBUtill.getUnverifiedEvent();
				request.setAttribute("event", er);
				RequestDispatcher dis =  request.getRequestDispatcher("AdminMain.jsp");
				dis.forward(request, response);
			}
			else {
				out.println("<script type = 'text/javascript'>");
				out.println("alert('Registration Error!!');");
				out.println("location='AddSP.jsp'");
				out.println("</script>");
				
			}
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('User Name already Taken!!');");
			out.println("location='AddSP.jsp'");
			out.println("</script>");
		}

		
		
	}

}
