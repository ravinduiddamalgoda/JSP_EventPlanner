<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Event Planner Login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');

        * {
            font-family: 'Poppins', sans-serif;
        }
        
        body {
            background-image: url("../img/back.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }      
        
 

        .LogingDiv {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .formCss {
            background-color: white;
            padding: 2rem;
            border: 1px solid #e5e7eb;
            border-radius: 0.5rem;
            text-align: center;
        }

        input[type="text"],
        input[type="password"] {
            border: 1px solid #e5e7eb;
            padding: 0.5rem;
            margin: 0.5rem 0;
            border-radius: 0.25rem;
        }
    </style>
</head>

<body class="bg-blue-100 ">
<div class="bg-cover bg-center h-screen" style="background-image: url('img/back.jpg');">
    <div class="LogingDiv">
        <h1 class="text-3xl font-semibold mb-4 text-white">Event Planner Login</h1>
        <form action="LoginEP" method="post" class="formCss shadow-2xl">
            <label for="username" class="block">User Name</label>
            <input type="text" name="username" placeholder="Enter your username" class="w-full"><br>
            <label for="password" class="block">Password</label>
            <input type="password" name="password" placeholder="Enter your password" class="w-full"><br>
            <a href="EP_Register.jsp" class="text-blue-500">New Event Planner? Click Here to Register.</a>
            <br>
            <input type="submit" name="submit" value="Login" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded-lg mt-2">
            <a href="AdminLogin.jsp" class="block mt-2 text-blue-500">Login As ADMIN</a>
            <a href="login.jsp" class="block mt-2 text-blue-500">Login As Event Finder</a>
        </form>
    </div>
</div> 
</body>

</html>