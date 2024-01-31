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

@WebServlet("/GetRequest")
public class GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String UserName = (String) session.getAttribute("SPUserName");
		ArrayList<ServiceRequest> SR = new ArrayList<ServiceRequest>();
		
		SR = SP_DB_Utill.getSRByServiceProviderUserName(UserName);
//		for (ServiceRequest request1 : SR) {
//		    System.out.println("Request ID: " + request1.getRequestId());
//		    System.out.println("Event Planner ID: " + request1.getEvtplID());
//		    System.out.println("Service ID: " + request1.getServiceID());
//		    System.out.println("Status: " + request1.isStatus());
//		    System.out.println("Event Planner Name: " + request1.getEventPlannerName());
//		    System.out.println("Event Planner Email: " + request1.getEventPlannerEmail());
//		    System.out.println("Service Name: " + request1.getServiceName());
//		    System.out.println(); // Add a separator between entries
//		}
		
		request.setAttribute("sr", SR);
		RequestDispatcher dis =  request.getRequestDispatcher("ViewRequests.jsp");
		dis.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String UserName = (String) session.getAttribute("SPUserName");
		ArrayList<ServiceRequest> SR = new ArrayList<ServiceRequest>();
		
		SR = SP_DB_Utill.getSRByServiceProviderUserName(UserName);
		
		request.setAttribute("sr", SR);
		RequestDispatcher dis =  request.getRequestDispatcher("ViewRequests.jsp");
		dis.forward(request, response);
		
		
	}

}
