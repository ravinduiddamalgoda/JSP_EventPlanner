package com.serviceProvider;

public class ServiceRequest {
    private int requestId;
    private int evtplID; // Event Planner ID
    private int serviceID;
    private boolean status;
    private String eventPlannerName;
    private String eventPlannerEmail;
    private String serviceName;

    public ServiceRequest(int requestId, int evtplID, int serviceID, boolean status, String eventPlannerName,
			String eventPlannerEmail, String serviceName) {
		super();
		this.requestId = requestId;
		this.evtplID = evtplID;
		this.serviceID = serviceID;
		this.status = status;
		this.eventPlannerName = eventPlannerName;
		this.eventPlannerEmail = eventPlannerEmail;
		this.serviceName = serviceName;
	}



    public String getEventPlannerName() {
		return eventPlannerName;
	}



	public void setEventPlannerName(String eventPlannerName) {
		this.eventPlannerName = eventPlannerName;
	}



	public String getEventPlannerEmail() {
		return eventPlannerEmail;
	}



	public void setEventPlannerEmail(String eventPlannerEmail) {
		this.eventPlannerEmail = eventPlannerEmail;
	}



	public String getServiceName() {
		return serviceName;
	}



	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}



	// Getters and setters for the class fields
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getEvtplID() {
        return evtplID;
    }

    public void setEvtplID(int evtplID) {
        this.evtplID = evtplID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "requestId=" + requestId +
                ", evtplID=" + evtplID +
                ", serviceID=" + serviceID +
                ", status=" + status +
                '}';
    }
}
