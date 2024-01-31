package com.admin.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.event.Event;
import com.event.PasswordHashing;
import com.user.DBConnect;

public class Admin_DBUtill {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validateAdmin(String username , String password)
	{	
		boolean stat = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from admin where username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				String hashPw = rs.getString(3);
				boolean pwVerify = PasswordHashing.verifyPassword(password, hashPw);
				
				if(pwVerify) {
					
					stat = true;
				}
				else {
					stat = false;
				}
			} else {
				stat = false;
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}		
		return stat;
	}
	
	public static boolean registerAdmin(String username, String password, String email, String adminPhoneno) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    boolean isTrue = false;
	    
	    String hashPw = PasswordHashing.hashPassword(password);

	    try {
	        con = DBConnect.getConnection();

	        String sql = "INSERT INTO Admin (username, password, email, AdminPhoneno) " +
	                     "VALUES (?, ?, ?, ?)";

	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, hashPw);
	        pstmt.setString(3, email);
	        pstmt.setString(4, adminPhoneno);

	        int rowsInserted = pstmt.executeUpdate();

	        if (rowsInserted > 0) {
	            isTrue = true;
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
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

	    return isTrue;
	}
	
	public static boolean checkUserName(String userName) {
			
			boolean valid = false;
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from admin where username='"+userName+"'";
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					
					System.out.println(rs.getString(2));
					valid =  false;
					
				}else {
					
					valid = true;
				}
				
				}catch(SQLException e) {
					System.out.println(e.getMessage());
					
				}
			
			
			return valid;
		}
	
	public static Admin getAdminByUserName(String userName) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Admin admin = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT * FROM Admin WHERE username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userName);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            admin = new Admin(
	                rs.getInt("adminID"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("email"),
	                rs.getString("adminPhoneno")
	            );
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage()); 
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage()); 
	        }
	    }

	    return admin;
	}
	
	
	public static ArrayList<Event> getUnverifiedEvent(){
		
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from event where VerifyStatus = false;";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int eventID = rs.getInt("EventID");
				String eventName = rs.getString("EventName");
				boolean verifyStatus = rs.getBoolean("VerifyStatus");
				String eventType = rs.getString("EventType");
				String eventDescription = rs.getString("EventDescription");
				String eventVenue = rs.getString("EventVenue");
				String eventData = rs.getString("EventDate");
				boolean enableTicketBooking = rs.getBoolean("EnableTicketBooking");
				
				Event ev =  new Event(eventID, eventName, verifyStatus, eventType, eventDescription, eventVenue, eventData, enableTicketBooking);
				eventList.add(ev);		
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		return eventList;
		
		
	}
	
	public static int getAdminID(String username) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int adminID = -1; // Default value if not found

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT adminID FROM Admin WHERE username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            adminID = rs.getInt("adminID");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
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

	    return adminID;
	}

	
	public static boolean verifyEvent(int adminID, int eventID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    boolean success = false;

	    try {
	        con = DBConnect.getConnection();

	        // Define the SQL query to update the event
	        String sql = "UPDATE Event SET VerifyStatus = true, AdminID = ? WHERE EventID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, adminID); // Parse the adminID as an integer
	        pstmt.setInt(2, eventID);

	        int rowsUpdated = pstmt.executeUpdate();

	        if (rowsUpdated > 0) {
	            // The update was successful
	            success = true;
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
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
	            System.out.println(e.getMessage());
	        }
	    }

	    return success;
	}
	
	public static boolean addServiceProvider(String username, String password, String name, String email, String company, String serviceDescription, String phoneNo) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    boolean success = false;
	    
	    String hashPw = PasswordHashing.hashPassword(password);

	    try {
	        con = DBConnect.getConnection();
	        
	        // Define the SQL query to insert a new service provider
	        String sql = "INSERT INTO Service_Provider (username, password, name, email, company, service_description, phone_no) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, hashPw);
	        pstmt.setString(3, name);
	        pstmt.setString(4, email);
	        pstmt.setString(5, company);
	        pstmt.setString(6, serviceDescription);
	        pstmt.setString(7, phoneNo);
	        
	        int rowsInserted = pstmt.executeUpdate();
	        
	        if (rowsInserted > 0) {
	            // The insert was successful
	            success = true;
	        }
	    } catch (SQLException e) {
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
	    
	    return success;
	}
	
	public static boolean ValidServiceProviderUserName(String username) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT username FROM Service_Provider WHERE username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        rs = pstmt.executeQuery();

	        // If the query returns a result, the username is already in use
	        return !rs.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
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

	    // An exception occurred or there was an issue with the query, return false
	    return false;
	}

	
}
