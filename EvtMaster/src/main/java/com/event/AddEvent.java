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


@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username =  (String) session.getAttribute("username");
		int evtplID = EP_DBUtill.getEPID_BY_username(username);
		String eventName = request.getParameter("eventName");
        String eventType = request.getParameter("eventType");
        String eventDescription = request.getParameter("eventDescription");
        String eventVenue = request.getParameter("eventVenue");
        String evtDate = request.getParameter("evtDate");
		
		boolean stat =  EP_DBUtill.addEvent(eventName, eventType, eventDescription, eventVenue, evtDate, evtplID);
		
		if(stat) {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Added Succesfully!!');");
			out.println("location='EventView.jsp'");
			out.println("</script>");
			EventPlanner ep =  EP_DBUtill.getEP_Data(username);
			request.setAttribute("EPData", ep);
			String ep_id = Integer.toString(ep.getEvtplID());
			ArrayList<Event> eventList = EP_DBUtill.getAllEventBY_evtplID(ep_id);
			request.setAttribute("eventList", eventList);
			RequestDispatcher dis =  request.getRequestDispatcher("EventView.jsp");
			dis.forward(request, response);
			
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Error while adding Event!!');");
			out.println("location='AddEvent.jsp'");
			out.println("</script>");
			
		}
		
	}

}
