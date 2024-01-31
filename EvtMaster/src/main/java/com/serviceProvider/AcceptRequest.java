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

@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String requestId = request.getParameter("requestId");
		
		boolean stat = SP_DB_Utill.updateServiceRequestStatus(requestId);
		
		if(stat) {
			String UserName = (String) session.getAttribute("SPUserName");
			ArrayList<ServiceRequest> SR = new ArrayList<ServiceRequest>();
			
			SR = SP_DB_Utill.getSRByServiceProviderUserName(UserName);
			
			request.setAttribute("sr", SR);
			RequestDispatcher dis =  request.getRequestDispatcher("ViewRequests.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error in Accepance!!');");
			out.println("</script>");
			
		}
		
	}

}
