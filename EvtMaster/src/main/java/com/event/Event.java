package com.event;

public class Event {
    private int eventID;
    private String eventName;
    private boolean verifyStatus;
    private String eventType;
    private String eventDescription;
    private String eventVenue;
    private String eventDate;
    private boolean enableTicketBooking;
    private int adminID;
    private int EVP_ID;

   

    public Event(int eventID, String eventName, boolean verifyStatus, String eventType, String eventDescription,
			String eventVenue, String eventDate, boolean enableTicketBooking, int adminID , int EVP_ID) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.verifyStatus = verifyStatus;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventVenue = eventVenue;
		this.eventDate = eventDate;
		this.enableTicketBooking = enableTicketBooking;
		this.adminID = adminID;
		this.EVP_ID = EVP_ID;
	}
    
    public Event(int eventID, String eventName, boolean verifyStatus, String eventType, String eventDescription,
			String eventVenue, String eventDate, boolean enableTicketBooking, int adminID) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.verifyStatus = verifyStatus;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventVenue = eventVenue;
		this.eventDate = eventDate;
		this.enableTicketBooking = enableTicketBooking;
		this.adminID = adminID;
	}
    
    public Event(int eventID, String eventName, boolean verifyStatus, String eventType, String eventDescription,
			String eventVenue, String eventDate, boolean enableTicketBooking) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.verifyStatus = verifyStatus;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventVenue = eventVenue;
		this.eventDate = eventDate;
		this.enableTicketBooking = enableTicketBooking;
		
	}
    

	public int getEVP_ID() {
		return EVP_ID;
	}

	public void setEVP_ID(int eVP_ID) {
		EVP_ID = eVP_ID;
	}

	public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(boolean verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isEnableTicketBooking() {
        return enableTicketBooking;
    }

    public void setEnableTicketBooking(boolean enableTicketBooking) {
        this.enableTicketBooking = enableTicketBooking;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
