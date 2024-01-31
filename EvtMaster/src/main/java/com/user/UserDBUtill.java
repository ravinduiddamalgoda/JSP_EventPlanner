package com.user;

import com.event.*;
import com.serviceProvider.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtill {
	
	private static boolean isTrue;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validateUserData(String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from User where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isTrue = true;
			} else {
				isTrue = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isTrue;
	}
	
	public static List<User> getSpecificCustomer(String username) {
		
		ArrayList<User> us =  new ArrayList<User>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from User where username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String un = rs.getString(2);
				String pw = rs.getString(3);
				int age = rs.getInt(4);
				String name = rs.getString(5);
				String email =  rs.getString(6);
				String phoneno =  rs.getString(7);
				
				User user =  new User(id ,un ,pw ,age , name , email , phoneno);
				us.add(user);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return us;
		
		
	}
	
	public static ArrayList<User> getSpecificUserByID(String userID) {
		
		ArrayList<User> us =  new ArrayList<User>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from User where userID='"+userID+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String un = rs.getString(2);
				String pw = rs.getString(3);
				int age = rs.getInt(4);
				String name = rs.getString(5);
				String email =  rs.getString(6);
				String phoneno =  rs.getString(7);
				
				User user =  new User(id ,un ,pw ,age , name , email , phoneno);
				us.add(user);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return us;
		
		
	}
	
	
	public static boolean registerUser(String username, String password, int age, String name, String email, String phoneno) {
	    Connection con = null;
	    Statement stmt = null;
	    boolean isTrue = false;
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "INSERT INTO User (userName, password, age, name, email, phoneno) " +
	                     "VALUES ('" + username + "', '" + password + "', " + age + ", '" + name + "', '" + email + "', '" + phoneno + "')";
	        stmt.executeUpdate(sql);
	        isTrue = true;
	    } catch (SQLException e) {
	       
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        }
	    }
	    
	    return isTrue;
	}

	
	
	public static ArrayList<Event>getEvent(){
		
		ArrayList<Event> eventData = new ArrayList<Event>();
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from event where EnableTicketBooking = TRUE AND VerifyStatus = TRUE";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				 int eventID =  rs.getInt(1);
			     String eventName = rs.getString(2);
			     boolean verifyStatus =  rs.getBoolean(3);
			     String eventType =  rs.getString(4);
			     String eventDescription = rs.getString(5);
			     String eventVenue = rs.getString(6);
			     String eventDate = rs.getString(7);
			     boolean enableTicketBooking = rs.getBoolean(8);
			     int adminID = rs.getInt(9);
			     
			     Event evt =  new Event(eventID , eventName , verifyStatus , eventType ,eventDescription ,  eventVenue , eventDate ,enableTicketBooking , adminID );
			     eventData.add(evt);
				
			}
			
			
			
		} 
		catch(Exception e) {
			
		}
		
		return eventData;
	}
	
	public static boolean UpdateData(String userID , String name , String email , String age , String phoneNO) {
		
		Connection con = null;
	    Statement stmt = null;
	    boolean isTrue = false;
		try {
			con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "UPDATE user SET name = '"+name+"', age = '"+ age+"', email = '"+email+"', phoneno = '"+phoneNO+"' WHERE userID = '"+userID+"';";
	        stmt.executeUpdate(sql);
			isTrue = true;
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return isTrue;
	}
	
	public static boolean DeleteUser (String userID) {
		Connection con = null;
	    Statement stmt = null;
	    boolean isTrue = false;
	    
	    try {
	    	con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "DELETE FROM user WHERE userID = '"+userID+"'";
	        stmt.executeUpdate(sql);
			isTrue = true;
	    	
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	
	    }
		
		
		return isTrue;
	}
	

	
	
	


	}
