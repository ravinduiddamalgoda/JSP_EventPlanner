package com.admin.manage;

public class Admin {
    private int adminID;
    private String username;
    private String password;
    private String email;
    private String adminPhoneno;

    public Admin() {
        // Default constructor
    }

    public Admin(int adminID, String username, String password, String email, String adminPhoneno) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adminPhoneno = adminPhoneno;
    }
    public Admin(int adminID, String username, String email, String adminPhoneno) {
        this.adminID = adminID;
        this.username = username;
        this.email = email;
        this.adminPhoneno = adminPhoneno;
    }

    
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminPhoneno() {
        return adminPhoneno;
    }

    public void setAdminPhoneno(String adminPhoneno) {
        this.adminPhoneno = adminPhoneno;
    }
}
