package com.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.serviceProvider.Service;
import com.user.DBConnect;

public class EP_DBUtill {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean loginEVP(String username , String password) {
		
		
		boolean loginState = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from eventplanner where username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				String hashPw = rs.getString(3);
				boolean pwVerify = PasswordHashing.verifyPassword(password, hashPw);
				
				if(pwVerify) {
					
					loginState = true;
				}
				else {
					loginState = false;
				}
			} else {
				loginState = false;
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}		
		return loginState;
	}
	
	
	public static boolean registerEVP(String username, String password, String name, String email, String companyName) {

	    Connection con = null;
	    PreparedStatement pstmt = null;
	    boolean isTrue = false;
	    
	    String hashPw = PasswordHashing.hashPassword(password);
	    

	    try {
	        con = DBConnect.getConnection();

	        String sql = "INSERT INTO eventPlanner (userName, password, name, email, companyName) " +
	                     "VALUES (?, ?, ?, ?, ?)";

	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, hashPw);
	        pstmt.setString(3, name);
	        pstmt.setString(4, email);
	        pstmt.setString(5, companyName);

	        int rowsInserted = pstmt.executeUpdate();

	        if (rowsInserted > 0) {
	            isTrue = true;
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

	    return isTrue;
	}
	
	
	public static int getEPID_BY_username(String userName)
	{	
		int returnID = 0;
		try {
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from eventplanner where userName='"+userName+"'";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt(1);
			returnID = id;
		}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		return returnID;
	}	
	
	public static EventPlanner getEP_Data(String username) {
	
		EventPlanner ep = null;
		try {
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from eventplanner where userName='"+username+"'";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int evtplID = rs.getInt(1);
			String userName =  rs.getString(2);
//			String password = rs.getString(3);
			String name =  rs.getString(4);
			String email =  rs.getString(5);
			String comName = rs.getString(6);
			
			ep =  new EventPlanner(evtplID , userName , name,email , comName);
			return ep;
		}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return ep;
	}
	
	public static boolean addEvent(String eventName, String eventType, String eventDescription, String eventVenue, String evtDate , int evtplID) {
	    Connection con = null;
	    Statement stmt = null;
	    boolean Sc = false;
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "INSERT INTO Event (EventName, EventType, EventDescription, EventVenue , EventDate , evtplID ) " +
	                     "VALUES ('" + eventName + "', '" + eventType + "', '" + eventDescription + "', '" + eventVenue + "' , '"+evtDate+"' , '"+evtplID+"')";
	        stmt.executeUpdate(sql);
	        Sc = true;
	    } catch (SQLException e) {
	        // Handle any database-related exceptions here
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	    } finally {
	        // Close resources in a finally block to ensure they are always closed
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            // Handle any closure-related exceptions here
	            e.printStackTrace();
	        }
	    }
	    
	    return Sc;
	}
	
	
	public static ArrayList<Event> getAllEventBY_evtplID(String evptlID){
		
		ArrayList<Event> eventList =  new ArrayList<Event>();
		int epID =  Integer.parseInt(evptlID);
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from event where evtplID='"+epID+"'";
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
				int adminID = rs.getInt("AdminID");

				
				Event ev =  new Event(eventID, eventName, verifyStatus, eventType, eventDescription, eventVenue, eventData, enableTicketBooking, adminID);
				eventList.add(ev);
				System.out.println(ev.getEventName());
			}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		
		
		return eventList;
		
		
	}
	
	public static boolean checkUserName(String userName) {
		
		boolean valid = false;
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from eventplanner where userName='"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				valid =  true;
				
			}else {
				
				valid = false;
			}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		
		
		return valid;
	}
	
	public static boolean UpdateTk_Enable(String eventID){
		Connection con = null;
	    Statement stmt = null;
	    boolean success = false;

	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "UPDATE Event SET EnableTicketBooking = true WHERE EventID = " + eventID;

	        int rowsUpdated = stmt.executeUpdate(sql);

	        if (rowsUpdated > 0) {
	            // The update was successful
	            success = true;
	        }
	    } catch (Exception e) {
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

	    return success;
	}
	
	public static boolean UpdateTk_Desable(String eventID){
		Connection con = null;
	    Statement stmt = null;
	    boolean success = false;

	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "UPDATE Event SET EnableTicketBooking = false WHERE EventID = " + eventID;

	        int rowsUpdated = stmt.executeUpdate(sql);

	        if (rowsUpdated > 0) {
	            // The update was successful
	            success = true;
	        }
	    } catch (Exception e) {
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

	    return success;
	}
	
	
	public static boolean DeleteEvent(String eventID) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    boolean success = false;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "DELETE FROM Event WHERE EventID = ?";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, eventID);

	        int rowsDeleted = preparedStatement.executeUpdate();

	        if (rowsDeleted > 0) {
	            // The delete was successful
	            success = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
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
	
	public static ArrayList<Service> getAllServices() {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<Service> services = new ArrayList<>();

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT * FROM service";
	        pstmt = con.prepareStatement(sql);

	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int serviceID = rs.getInt("serviceID");
	            String serviceName = rs.getString("serviceName");
	            String serviceType = rs.getString("serviceType");
	            String serviceDescription = rs.getString("serviceDescription");
	            boolean availableStatus = rs.getBoolean("availableStatus");
	            int spID = rs.getInt("spID");

	            // Create a Service object and add it to the list
	            Service service = new Service(serviceID, serviceName, serviceType, serviceDescription, availableStatus, spID);
	            services.add(service);
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

	    return services;
	}

	
	public static boolean addRequest(int evtplID, String serviceID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "INSERT INTO service_request (evtplID, serviceID) VALUES (?, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, evtplID);
	        pstmt.setInt(2, Integer.parseInt(serviceID));

	        int rowsInserted = pstmt.executeUpdate();

	        if (rowsInserted > 0) {
	            // If one or more rows were inserted, the request was added successfully.
	            return true;
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
	        	System.out.println(e.getMessage());
	        }
	    }

	    // If no rows were inserted or an error occurred, return false.
	    return false;
	}

	
	
}
