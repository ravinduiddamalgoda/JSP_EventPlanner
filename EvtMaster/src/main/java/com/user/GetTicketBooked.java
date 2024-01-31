package com.user;

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

@WebServlet("/GetTicketBooked")
public class GetTicketBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userID =  (String) session.getAttribute("userID");
		ArrayList<TicketBookClass> BookedTickets = new ArrayList<TicketBookClass>();
		BookedTickets = TicketBookingUtill.getBookedTicketsByUserID(userID);
		
		request.setAttribute("BookedTicket", BookedTickets);
		RequestDispatcher dis =  request.getRequestDispatcher("viewMyTicket.jsp");
		dis.forward(request, response);
		
		
	}

}
