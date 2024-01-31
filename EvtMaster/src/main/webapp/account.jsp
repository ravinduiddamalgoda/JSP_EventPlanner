<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account</title>
<style>
	p{
		text-align: center;
	}
    body {
        font-family: Arial, sans-serif;
        padding: 20px;
        background-color: #f2f2f2;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        margin-top: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #0077d1;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 15px;
    }

    input[type="submit"]:hover {
        background-color: #0077d1;
    }
</style>
</head>
<body>
    <c:forEach var="user" items="${User}">
    <p><h1>Welcome <c:out value="${user.name}" /></h1></p>
    
    <h1>Edit Details</h1>
	<form action="UpdateUser" method="post">
		<!-- Name -->
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" value="${user.name}"><br>
		<!-- Email -->
		<label for="email">Email:</label>
		<input type="text" name="email" value="${user.email}"><br>
		<!-- Age -->
		<label for="age">Age:</label>
		<input type="text" id="age" name="age" value="${user.age}"><br>
		<!-- Phone Number -->
		<label for="phoneno">Phone Number:</label>
		<input type="text" id="phoneno" name="phoneno" value="${user.phoneno}"><br>
		<input type="submit" value="Update Data">
	</form>
	
	<form action="DeleteUser" method="post" onsubmit="return confirmDelete();">
		<input type="hidden" id="userID" name="userID" value="${user.userID}"><br>
		<input type="submit" value="Delete Account">
	</form>
	
	<script>
		function confirmDelete() {
			return confirm("Are you sure you want to delete this account?");
		}
	</script>

		<script>
		    function confirmDelete() {
		        return confirm("Are you sure you want to delete this account?");
		    }
		</script>
	    
	    
		</c:forEach>

</body>

</html>