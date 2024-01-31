<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Event Planner Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    <script>
        function validateForm() {
            var password = document.getElementById("password").value;

            // Check if the password is at least 8 characters long and contains a special character
            if (password.length < 8 || !/[!@#$%^&*()_+{}\[\]:;<>,.?~\\-]/.test(password)) {
                alert("Password must be at least 8 characters long and contain a special character.");
                return false;
            }
            return true;
        }
    </script>
    <style>
    	    @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
    
   		h1{
			font-family:'Poppins';
   		}
   		
   		label{
			font-family:'Poppins';
   		}
   		
   		button{
   			font-family:'Poppins';
   		}
    
    </style>
   
</head>

<body class="bg-blue-100 ">
    <div class="container mx-auto p-4 w-96">
        <h1 class="text-3xl font-bold mb-4 text-center">Event Planner Registration</h1>
        <form action="RegisterEP" method="post" onsubmit="return validateForm()" class="bg-white p-6 rounded-lg shadow-md">
            <div class="mb-4">
                <label for="userName" class="block text-gray-700 font-bold">Username:</label>
                <input type="text" id="userName" name="userName" class="w-full px-3 py-2 border rounded-lg" required>
            </div>

            <div class="mb-4">
                <label for="password" class="block text-gray-700 font-bold">Password:</label>
                <input type="password" id="password" name="password" class="w-full px-3 py-2 border rounded-lg" required>
            </div>

            <div class="mb-4">
                <label for="name" class="block text-gray-700 font-bold">Full Name:</label>
                <input type="text" id="name" name="name" class="w-full px-3 py-2 border rounded-lg" required>
            </div>

            <div class="mb-4">
                <label for="email" class="block text-gray-700 font-bold" >Email:</label>
                <input type="email" id="email" name="email" class="w-full px-3 py-2 border rounded-lg" required>
            </div>

            <div class="mb-4">
                <label for="companyName" class="block text-gray-700 font-bold">Company Name:</label>
                <input type="text" id="companyName" name="companyName" class="w-full px-3 py-2 border rounded-lg" required>
            </div>

            <button type="submit" class="bg-blue-500 text-white font-bold py-2 px-4 rounded-lg mx-auto block">Register Event Planner</button>
        </form>
    </div>
</body>

</html>