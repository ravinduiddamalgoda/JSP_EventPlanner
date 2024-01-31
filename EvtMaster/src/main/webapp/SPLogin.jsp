<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service Provider Login</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-200">
    <div class="container mx-auto flex justify-center items-center h-screen">
        <div class="w-full max-w-sm p-4 bg-white rounded shadow-md">
            <h1 class="text-2xl text-center mb-4">Service Provider Login</h1>
            <form action="LoginSP" method="post">
                <div class="mb-4">
                    <label for="username" class="block text-sm font-medium text-gray-600">User Name</label>
                    <input type="text" name="username" id="username" placeholder="Enter your username" class="w-full px-3 py-2 border rounded-lg">
                </div>
                <div class="mb-4">
                    <label for="password" class="block text-sm font-medium text-gray-600">Password</label>
                    <input type="password" name="password" id="password" placeholder="Enter your password" class="w-full px-3 py-2 border rounded-lg">
                </div>
                <div class="mb-4">
                    <input type="submit" name="submit" value="Login" class="w-full bg-blue-500 text-white font-semibold py-2 rounded-lg hover:bg-blue-600 cursor-pointer">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
