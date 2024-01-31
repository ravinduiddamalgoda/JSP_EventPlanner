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

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;

import com.event.Event;

@WebServlet("/TicketRecerve")
public class TicketRecerve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID =  (String) session.getAttribute("userID");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int cnt = 0;
		if(!(request.getParameter("count") == null) ) {
			cnt = Integer.parseInt(request.getParameter("count"));
		}
		
		String ticketID =request.getParameter("ticketID");
		System.out.println(ticketID);
		boolean state = TicketBookingUtill.bookTicket(userID, ticketID, cnt);
		
		if(state) {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Ticket Booked!');");
			out.println("</script>");
			ArrayList<Event> eventList = UserDBUtill.getEvent();
			request.setAttribute("eventList", eventList);
			RequestDispatcher dis =  request.getRequestDispatcher("TicketBook.jsp");
			dis.forward(request, response);
			
		}else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error!! ');");
			out.println("</script>");
		}
		
		if(cnt == 0) {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Please Enter an Count! ');");
			out.println("</script>");
			request.setAttribute("eventID", ticketID);
			RequestDispatcher dis =  request.getRequestDispatcher("TicketBook.jsp");
			dis.forward(request, response);
		}
		
		
		
	}

}
