package com.event;

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

import com.serviceProvider.Service;


@WebServlet("/RequestService")
public class RequestService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username =  (String) session.getAttribute("username");
		int evtplID = EP_DBUtill.getEPID_BY_username(username);
		String serviceID = request.getParameter("serviceID");
		
		boolean stat = EP_DBUtill.addRequest(evtplID, serviceID);
		
		if(stat) {
			ArrayList<Service> sp = EP_DBUtill.getAllServices();
			request.setAttribute("serviceList", sp); 
			RequestDispatcher dis =  request.getRequestDispatcher("EventView.jsp"); 
			dis.forward(request, response);
			
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error Occured!!');");
			out.println("location='EventView.jsp'");
			out.println("</script>");
			
		}
		
	}

}
