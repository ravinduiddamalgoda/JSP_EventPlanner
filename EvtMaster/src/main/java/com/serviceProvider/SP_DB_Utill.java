package com.serviceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.event.PasswordHashing;
import com.user.DBConnect;

public class SP_DB_Utill {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validateServiceProvider(String username, String password) {
	    boolean isValid = false;

	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "SELECT * FROM Service_Provider WHERE username = '" + username + "'";
	        rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            String hashPw = rs.getString("password");
	            boolean isPasswordValid = PasswordHashing.verifyPassword(password, hashPw);

	            if (isPasswordValid) {
	                isValid = true;
	            } else {
	                isValid = false;
	            }
	        } else {
	            isValid = false;
	        }
	    } catch (Exception e) {
	        System.out.print(e.getMessage());
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
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

	    return isValid;
	}
	
	public static ArrayList<Service> getServicesByUserName(String username) {
	    ArrayList<Service> services = new ArrayList<>();
	    
	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT * FROM Service WHERE spID IN (SELECT spID FROM Service_Provider WHERE username = ?)";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Service service = new Service();
	            service.setServiceID(rs.getInt("serviceID"));
	            service.setServiceName(rs.getString("serviceName"));
	            service.setServiceType(rs.getString("serviceType"));
	            service.setServiceDescription(rs.getString("serviceDescription"));
	            service.setAvailableStatus(rs.getBoolean("availableStatus"));
	            service.setSpID(rs.getInt("spID"));
	            
	            services.add(service);
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
	    
	    return services;
	}
	
	
	public static int getServiceProviderIDByUsername(String serviceProviderUsername) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int spID = -1; // Default value if not found

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT spID FROM service_provider WHERE username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, serviceProviderUsername);

	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            spID = rs.getInt("spID");
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

	    return spID;
	}
	
	public static boolean addService(String serviceName, String serviceType, String serviceDescription, boolean availableStatus, String serviceProviderUsername) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    boolean isServiceAdded = false;

	    try {
	        con = DBConnect.getConnection();

	        
	        int spID = getServiceProviderIDByUsername(serviceProviderUsername);

	        if (spID != -1) {
	            String sql = "INSERT INTO Service (serviceName, serviceType, serviceDescription, availableStatus, spID) VALUES (?, ?, ?, ?, ?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, serviceName);
	            pstmt.setString(2, serviceType);
	            pstmt.setString(3, serviceDescription);
	            pstmt.setBoolean(4, availableStatus);
	            pstmt.setInt(5, spID);

	            int rowsInserted = pstmt.executeUpdate();

	            if (rowsInserted > 0) {
	                isServiceAdded = true;
	            }
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

	    return isServiceAdded;
	}
	
	
	public static boolean deleteService(String serviceID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "DELETE FROM Service WHERE serviceID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Integer.parseInt(serviceID));

	        int rowsDeleted = pstmt.executeUpdate();

	        if (rowsDeleted > 0) {
	            // If one or more rows were deleted, the service was successfully deleted.
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

	    // If no rows were deleted, the service was not found or an error occurred.
	    return false;
	}
	
	public static boolean AvailableFalse(String serviceID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "UPDATE Service SET availableStatus = ? WHERE serviceID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setBoolean(1, false);
	        pstmt.setInt(2, Integer.parseInt(serviceID));

	        int rowsUpdated = pstmt.executeUpdate();

	        if (rowsUpdated > 0) {
	            // If one or more rows were updated, the availability was set to false.
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

	    // If no rows were updated, the service was not found or an error occurred.
	    return false;
	}
	
	public static boolean AvailableTrue(String serviceID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "UPDATE Service SET availableStatus = ? WHERE serviceID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setBoolean(1, true);
	        pstmt.setInt(2, Integer.parseInt(serviceID));

	        int rowsUpdated = pstmt.executeUpdate();

	        if (rowsUpdated > 0) {
	            // If one or more rows were updated, the availability was set to true.
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

	    // If no rows were updated, the service was not found or an error occurred.
	    return false;
	}

	
	

	public static ArrayList<ServiceRequest> getSRByServiceProviderUserName(String username) {
	    ArrayList<ServiceRequest> serviceRequests = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT sr.srID, sr.evtplID, sr.serviceID, sr.status, " +
	                     "epl.name AS eventPlannerName, epl.email AS eventPlannerEmail, " +
	                     "s.serviceName AS serviceName " +
	                     "FROM service_request sr " +
	                     "JOIN eventplanner epl ON sr.evtplID = epl.evtplID " +
	                     "JOIN service s ON sr.serviceID = s.serviceID " +
	                     "JOIN service_provider sp ON s.spID = sp.spID " +
	                     "WHERE sp.username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            ServiceRequest sr = new ServiceRequest(
	                rs.getInt("srID"),
	                rs.getInt("evtplID"),
	                rs.getInt("serviceID"),
	                rs.getBoolean("status"),
	                rs.getString("eventPlannerName"),
	                rs.getString("eventPlannerEmail"),
	                rs.getString("serviceName")
	            );

	            serviceRequests.add(sr);
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
	        	System.out.println(e.getMessage());
	        }
	    }

	    return serviceRequests;
	}
	
	public static boolean updateServiceRequestStatus(String requestID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "UPDATE service_request SET status = true WHERE srID = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Integer.parseInt(requestID));

	        int rowsUpdated = pstmt.executeUpdate();

	        return rowsUpdated > 0;
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

	    return false;
	}


	


}
