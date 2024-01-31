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


@WebServlet("/GetServices")
public class GetServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				PrintWriter out = response.getWriter(); response.setContentType("text/html"); 
				HttpSession session = request.getSession(); 
				ArrayList<Service> sp = EP_DBUtill.getAllServices();
				request.setAttribute("serviceList", sp); 
				RequestDispatcher dis =  request.getRequestDispatcher("RequestService.jsp"); 
				dis.forward(request, response);
	}

}
