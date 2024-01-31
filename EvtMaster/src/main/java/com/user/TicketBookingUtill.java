package com.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.event.*;

public class TicketBookingUtill {
	
	
	
	public static ArrayList<Ticket> GetTicket(String EventID) {
		
		Connection con = null;
	    Statement stmt = null;
		
		ArrayList<Ticket> tkArr = new ArrayList<Ticket> ();
		try {
			con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "Select * from Ticket where eventID = '"+EventID+"'";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while(rs.next()) {
	        	int ticketID =  rs.getInt(1);
	        	double price =  rs.getDouble(2);
	        	String ticketType =  rs.getString(3);
	        	String disCode = rs.getString(4);
	        	int eventID = rs.getInt(5);
	        	
	        	Ticket tk = new Ticket(ticketID , price , ticketType , disCode , eventID);
	        	tkArr.add(tk);
	        	
	        }
	        
			
		}
		catch(Exception e) {
			
		}

			
		
		
		return tkArr;
	}
	
	
	public static boolean bookTicket (String userID , String ticketID , int count) {
		
		boolean success = false;
		Connection con = null;
	    Statement stmt = null;
	    java.util.Date currentDate = new java.util.Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String date = dateFormat.format(currentDate);
	    Date sqlDate = Date.valueOf(date);
	    
	    try {
	    	 con = DBConnect.getConnection();
		     stmt = con.createStatement();
	        String sql = "INSERT INTO Ticket_Book (TicketID, UserID, Date , Count )VALUES ('"+ticketID+"', '"+userID+"', '"+sqlDate+"' , '"+count+"')";
		     stmt.executeUpdate(sql);
		     success = true;
	    	
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	
	    }
 
		
		return success;
	}
	
	public static ArrayList<TicketBookClass> getBookedTicketsByUserID(String userID) {
		ArrayList<TicketBookClass> bookedTickets = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT TicketID, Date, Count FROM Ticket_Book WHERE UserID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userID);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String ticketID = rs.getString("TicketID");
	            String date = rs.getString("Date");
	            int count = rs.getInt("Count");

	            // Create a TicketBooking object and add it to the list
	            TicketBookClass booking = new TicketBookClass(ticketID, userID, date, count);
	            bookedTickets.add(booking);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return bookedTickets;
	}

	
	public static boolean hasBookedTicket(String userID, String ticketID) {

	    boolean hasBooked = false;
	    Connection con = null;
	    Statement stmt = null;

	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();

	        // Check if a row exists in Ticket_Book with the given userID and ticketID
	        String sql = "SELECT COUNT(*) FROM Ticket_Book WHERE UserID = '" + userID + "' AND TicketID = '" + ticketID + "'";
	        ResultSet result = stmt.executeQuery(sql);

	        if (result.next()) {
	            int rowCount = result.getInt(1);
	            if (rowCount > 0) {
	                hasBooked = true;
	            }
	        }

	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }

	    return hasBooked;
	}


}
