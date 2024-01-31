<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Service Provider</title>
<script src="https://cdn.tailwindcss.com"></script>
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var company = document.getElementById("company").value;
            var serviceDescription = document.getElementById("service_description").value;
            var phoneNo = document.getElementById("phone_no").value;

            // Check if any of the required fields are empty
            if (username === "" || password === "" || name === "" || email === "" || company === "" || serviceDescription === "" || phoneNo === "") {
                alert("All fields are required");
                return false;
            }

            // Check if the password meets the criteria
            if (password.length < 8 || !password.match(/[@#$%^&+=]/)) {
                alert("Password must be at least 8 characters long and include at least one symbol (@, #, $, %, ^, &, +, =)");
                return false;
            }
            
            var phoneNoPattern = /^\d{10}$/;
            if (!phoneNo.match(phoneNoPattern)) {
                alert("Phone number must be a 10-digit number");
                return false;
            }
            
            

            return true;
        }
    </script>
</head>
<body class="bg-gray-100 p-6">
	<% String successMessage = (String) request.getAttribute("successMessage"); %>
	<% if (successMessage != null) { %>
	    <div class="alert alert-success">
	        <strong>Success:</strong> <%= successMessage %>
	    </div>
	<% } %>
    <div class="container mx-auto max-w-md bg-white rounded-lg shadow-md p-6">
        <h2 class="text-2xl font-semibold mb-4">Add Service Provider</h2>
        <form action="AddSPAdmin" method="POST" onsubmit="return validateForm()" class="space-y-4">
            <div class="flex flex-col">
                <label for="username" class="text-gray-600">Username:</label>
                <input type="text" id="username" name="username" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="password" class="text-gray-600">Password:</label>
                <input type="password" id="password" name="password" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="name" class="text-gray-600">Name:</label>
                <input type="text" id="name" name="name" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="email" class="text-gray-600">Email:</label>
                <input type="email" id="email" name="email" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="company" class="text-gray-600">Company:</label>
                <input type="text" id="company" name="company" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="service_description" class="text-gray-600">Service Description:</label>
                <textarea id="service_description" name="service_description" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300"></textarea>
            </div>
            <div class="flex flex-col">
                <label for="phone_no" class="text-gray-600">Phone Number:</label>
                <input type="text" id="phone_no" name="phone_no" class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-2 rounded-lg">Add Service Provider</button>
        </form>
    </div>
</body>
</html>