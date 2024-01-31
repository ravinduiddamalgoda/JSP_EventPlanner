<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
  }

  h1 {
    text-align: center;
  }

  form {
    width: 500px;
    margin: 0 auto;
    background-color: #ffffff;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  input[type="text"],
  input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  input[type="submit"] {
    width: 100%;
    background-color: #0077d1;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #0077d1;
  }

  button {
    width: 100%;
    background-color: #0077d1;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  button:hover {
    background-color: #0077d1;
  }

  #lg_admin{
   width: 25%;
  background-color: #0077d1;
  color: #ccc;
  margin:  8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  }

  #lg_admin a{
    color: whitesmoke;
    text-decoration: none;
  }

  #event{
   width: 25%;
  background-color: #0077d1;
  color: #ebebeb;
  margin:  80px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  }

  #event a{
    color: whitesmoke;
    text-decoration: none;
  }
  
  .ds{
    margin-left: 400px;
  }

  a{
    text-decoration: none;
    color: black;
  }
  a:hover{
    color: #0077d1;
  }


</style>
</head>
<body>
  <h1>LOG IN</h1>
  <form action="UserLogin" method="post">
    User Name <input type="text" name="username" placeholder="Enter your username"><br>
    Password <input type="password" name="password" placeholder="Enter your password"><br><br>
    <a href="RegisterUser.jsp">Click Here to Register for New Customers</a>
    <br><br>
    <input type="submit" name="submit" value="Login">
  </form>

  <div class="ds">
    <button id="lg_admin"><a href="AdminLogin.jsp">Login As ADMIN</a></button>
    <button id="event"><a href="EventPlannerLogin.jsp">Login As Event Planner</a></button>
  </div>>
</body>
</html>