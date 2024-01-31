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


@WebServlet("/LoginEP")
public class LoginEP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
			isTrue = EP_DBUtill.loginEVP(userName, password);
			
			if(isTrue) {
				session.setAttribute("username", userName);
				EventPlanner ep =  EP_DBUtill.getEP_Data(userName);
				
				request.setAttribute("EPData", ep);
				
				String ep_id = Integer.toString(ep.getEvtplID());
				System.out.println(ep_id);
				ArrayList<Event> eventList = EP_DBUtill.getAllEventBY_evtplID(ep_id);
				for(Event ep1: eventList) {
					System.out.println(ep1.getEventName());
				}
				request.setAttribute("eventList", eventList);
				RequestDispatcher dis =  request.getRequestDispatcher("EventView.jsp");
				dis.forward(request, response);
				out.print("<script type = 'text/javascript'>");
				out.print("location='EventView.jsp'");
				out.print("</script>");
			}else {
				out.println("<script type = 'text/javascript'>");
				out.println("alert('Your username or Password is incorrect!!');");
				out.println("location='EventPlannerLogin.jsp'");
				out.println("</script>");
				
			}
			
		
	}

}
