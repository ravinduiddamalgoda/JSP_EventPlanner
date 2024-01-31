package com.serviceProvider;

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

import com.admin.manage.Admin_DBUtill;
import com.event.Event;



@WebServlet("/LoginSP")
public class LoginSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		
		isTrue = SP_DB_Utill.validateServiceProvider(userName, password);
		if(isTrue) {
			session.setAttribute("SPUserName", userName);
			ArrayList<Service> services = SP_DB_Utill.getServicesByUserName(userName);
			request.setAttribute("service", services);
			RequestDispatcher dis =  request.getRequestDispatcher("ServiceProviderMain.jsp");
			dis.forward(request, response);
			out.print("<script type = 'text/javascript'>");
			out.print("location='SPLogin.jsp'");
			out.print("</script>");
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your username or Password is incorrect!!');");
			out.println("location='SPLogin.jsp'");
			out.println("</script>");
			
		}
		
		
	}

}
