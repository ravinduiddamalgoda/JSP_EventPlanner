package com.user;

public class TicketBookClass {
	private String ticketID;
    private String userID;
    private String date;
    private int count;

    public TicketBookClass(String ticketID, String userID, String date, int count) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.date = date;
        this.count = count;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
 

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

  
    
}
