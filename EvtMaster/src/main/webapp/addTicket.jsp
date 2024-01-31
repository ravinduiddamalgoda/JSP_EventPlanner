<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Add</title>
</head>
<body>
	<h1>Add New Ticket</h1>
    <form action="AddTicket" method="post">
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" required><br>

        <label for="ticketType">Ticket Type:</label>
        <input type="text" id="ticketType" name="ticketType" required><br>

        <label for="discountCode">Discount Code:</label>
        <input type="text" id="discountCode" name="discountCode"><br>

        <input type="submit" value="Add Ticket">
    </form>

</body>
</html>