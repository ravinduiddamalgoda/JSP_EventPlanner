<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Register</title>
<script src="https://cdn.tailwindcss.com"></script>
<head>
    <title>Admin Registration</title>
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var email = document.getElementById("email").value;
            var adminPhoneno = document.getElementById("adminPhoneno").value;

            if (username === "" || email === "" || adminPhoneno === "") {
                alert("All fields are required");
                return false;
            }

            if (password.length < 8 || !password.match(/[@#$%^&+=]/)) {
                alert("Password must be at least 8 characters long and include at least one symbol (@, #, $, %, ^, &, +, =)");
                return false;
            }

            return true;
        }
    </script>
</head>
<body class="bg-gray-100 p-6">
    <div class="container mx-auto max-w-md bg-white rounded-lg shadow-md p-6">
        <h2 class="text-2xl font-semibold mb-4">Admin Registration</h2>
        <form action="AdminRegister" method="POST" onsubmit="return validateForm()" class="space-y-4">
            <div class="flex flex-col">
                <label for="username" class="text-gray-600">Username:</label>
                <input type="text" id="username" name="username" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="password" class="text-gray-600">Password:</label>
                <input type="password" id="password" name="password" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="email" class="text-gray-600">Email:</label>
                <input type="email" id="email" name="email" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="adminPhoneno" class="text-gray-600">Phone Number:</label>
                <input type="text" id="adminPhoneno" name="adminPhoneno" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-2 rounded-lg">Register</button>
        </form>
    </div>
</body>
</html>