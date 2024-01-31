package com.user;


import com.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TicketBooking")
public class TicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("eventId");
		
		ArrayList<Ticket> tkArr =  new ArrayList<Ticket>();
		
		try {
			
			tkArr = TicketBookingUtill.GetTicket(id);
			request.setAttribute("ticketList", tkArr);
			request.setAttribute("eventID", id);
			RequestDispatcher dis =  request.getRequestDispatcher("TicketViewEvent.jsp");
			dis.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
