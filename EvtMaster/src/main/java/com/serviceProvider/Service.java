package com.serviceProvider;

public class Service {
    private int serviceID;
    private String serviceName;
    private String serviceType;
    private String serviceDescription;
    private boolean availableStatus;
    private int spID;

    public Service(int serviceID, String serviceName, String serviceType, String serviceDescription,
			boolean availableStatus, int spID) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.serviceDescription = serviceDescription;
		this.availableStatus = availableStatus;
		this.spID = spID;
	}

	public Service() {
        // Default constructor
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public boolean isAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    public int getSpID() {
        return spID;
    }

    public void setSpID(int spID) {
        this.spID = spID;
    }
}
