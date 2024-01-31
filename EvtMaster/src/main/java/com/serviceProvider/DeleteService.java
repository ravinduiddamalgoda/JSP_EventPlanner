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
 * Servlet implementation class DeleteService
 */
@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String serviceID = request.getParameter("serviceID");
		String UserName = (String) session.getAttribute("SPUserName");
		boolean stat = SP_DB_Utill.deleteService(serviceID);
		
		if(stat) {
			ArrayList<Service> services = SP_DB_Utill.getServicesByUserName(UserName);
			request.setAttribute("service", services);
			RequestDispatcher dis =  request.getRequestDispatcher("ServiceProviderMain.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error in Delete!!');");
			out.println("</script>");
		}
		
		
	}

}
