package com.event;

public class Ticket {
    private int ticketID;
    private double price;
    private String ticketType;
    private String discountCode;
    private int eventID;

 

    public Ticket(int ticketID, double price, String ticketType, String discountCode, int eventID) {

		this.ticketID = ticketID;
		this.price = price;
		this.ticketType = ticketType;
		this.discountCode = discountCode;
		this.eventID = eventID;
	}
    public Ticket(double price, String ticketType, String discountCode, int eventID) {

		
		this.price = price;
		this.ticketType = ticketType;
		this.discountCode = discountCode;
		this.eventID = eventID;
	}

	public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
}
