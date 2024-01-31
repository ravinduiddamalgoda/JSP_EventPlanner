<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script>
        function validateForm() {
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            var age = document.getElementById("age").value;
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var phoneNo = document.getElementById("phoneno").value;
            
            // Simple username validation (can be more complex)
            if (userName.trim() === "") {
                alert("Username is required.");
                return false;
            }

            // Simple password validation (can be more complex)
            if (password.trim() === "") {
                alert("Password is required.");
                return false;
            }

            // Age validation (must be at least 18)
            if (isNaN(age) || age < 18) {
                alert("Age must be a number and at least 18.");
                return false;
            }

            // Name validation (can be more complex)
            if (name.trim() === "") {
                alert("Name is required.");
                return false;
            }

            // Email validation (can be more complex)
            if (!validateEmail(email)) {
                alert("Invalid email address.");
                return false;
            }

            // Phone number validation (must be 10 digits)
            if (!/^\d{10}$/.test(phoneNo)) {
                alert("Phone number must be 10 digits.");
                return false;
            }

            return true;
        }

        function validateEmail(email) {
            // A simple email validation regex
            var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailRegex.test(email);
        }
    </script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        padding: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 10px;
        color: #555;
    }

    input[type="text"],
    input[type="password"],
    input[type="number"],
    input[type="email"],
    input[type="tel"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #0077d1;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #0077d1;
    }
</style>
</head>
<body>
    <h1>REGISTER</h1>
     <form action="UserRegister" method="post" onsubmit="return validateForm()">
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required min="18"><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name "name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="phoneno">Phone Number:</label>
        <input type="tel" id="phoneno" name="phoneno" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>