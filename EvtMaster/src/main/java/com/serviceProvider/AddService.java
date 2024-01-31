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

/**
 * Servlet implementation class AddService
 */
@WebServlet("/AddService")
public class AddService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String serviceName = request.getParameter("serviceName");
		String serviceType = request.getParameter("serviceType");
		String serviceDescription = request.getParameter("serviceDescription");
		String availableStatusString = request.getParameter("availableStatus");
		boolean availableStatus = "true".equals(availableStatusString); // Convert to boolean
		String UserName = (String) session.getAttribute("SPUserName");
		
		boolean stat = SP_DB_Utill.addService(serviceName, serviceType, serviceDescription, availableStatus, UserName);
		
		if(stat) {
			ArrayList<Service> services = SP_DB_Utill.getServicesByUserName(UserName);
			request.setAttribute("service", services);
			RequestDispatcher dis =  request.getRequestDispatcher("ServiceProviderMain.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error!!');");
			out.println("location='add-service.jsp'");
			out.println("</script>");
			
		}



	}

}
