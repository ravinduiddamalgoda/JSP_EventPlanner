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


@WebServlet("/UnableTKBooking")
public class UnableTKBooking extends HttpServlet {
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
		String eventID = request.getParameter("eventID");
		boolean stat  = EP_DBUtill.UpdateTk_Enable(eventID);
		
		if(stat) {
			EventPlanner ep =  EP_DBUtill.getEP_Data(username);
			request.setAttribute("EPData", ep);
			String ep_id = Integer.toString(ep.getEvtplID());
			ArrayList<Event> eventList = EP_DBUtill.getAllEventBY_evtplID(ep_id);
			request.setAttribute("eventList", eventList);
			RequestDispatcher dis =  request.getRequestDispatcher("EventView.jsp");
			dis.forward(request, response);
			
		}else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Update Unsuccessfull!!');");
			out.println("location='EventView.jsp'");
			out.println("</script>");
		}
	
		}

}
