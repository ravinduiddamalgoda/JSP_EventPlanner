package com.event;

public class EventPlanner {
    private int evtplID;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String companyName;

 
    // Parameterized constructor
    public EventPlanner(int evtplID, String userName, String password, String name, String email, String companyName) {
        this.evtplID = evtplID;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.companyName = companyName;
    }
    public EventPlanner(int evtplID, String userName, String name, String email, String companyName) {
        this.evtplID = evtplID;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.companyName = companyName;
    }

    // Getters and setters for the class fields
    public int getEvtplID() {
        return evtplID;
    }

    public void setEvtplID(int evtplID) {
        this.evtplID = evtplID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

