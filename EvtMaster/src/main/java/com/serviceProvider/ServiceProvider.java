package com.serviceProvider;

public class ServiceProvider {
    private int spID;
    private String username;
    private String password;
    private String name;
    private String email;
    private String company;
    private String serviceDescription;
    private String phoneNo;

    public ServiceProvider() {
        // Default constructor
    }
    
    public ServiceProvider(int spID, String username, String password, String name, String email, String company,
			String serviceDescription, String phoneNo) {
		super();
		this.spID = spID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.company = company;
		this.serviceDescription = serviceDescription;
		this.phoneNo = phoneNo;
	}
    public int getSpID() {
        return spID;
    }

    public void setSpID(int spID) {
        this.spID = spID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
