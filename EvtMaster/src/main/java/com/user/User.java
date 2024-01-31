package com.user;

public class User {
   
    private int userID;
    private String userName;
    private String password;
    private int age;
    private String name;
    private String email;
    private String phoneno;

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public User(int UserID ,String userName, String password, int age, String name, String email, String phoneno) {
        this.userID = UserID;
    	this.userName = userName;
        this.password = password;
        this.age = age;
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
    }

    // Getters and Setters for all fields

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}