<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tickets</title>
    <style>
    
    
    	h1{
    		text-align: center;
            font-size: 2.8rem;
            color: #27005D;
            margin: 20px 0;
            margin-bottom:75px;
            text-shadow: 6px 3px 4px rgba(0, 0, 0, 0.2);
    	
    	}
    
    
    
        body {
            font-family: 'Poppins', sans-serif;
            background: #E4F1FF;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 1250px;
            margin: 20px auto;
            background: #fff;
            border-radius: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        th, td {
            padding: 15px;
            text-align: center;
            border: 1px solid #ddd;
            
        }

        th {
            background-color: #0077b6;
            color: #fff;
        }

        td {
            background-color: #f8f8f8;
            color: #333;
        }

        input[type="number"] {
            width: 40px;
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #0077b6;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #005686;
        }
    </style>
</head>
<body>
    <h1>Reserve a Ticket</h1>
    <table>
        <thead>
            <tr>
                <th>Ticket Type</th>
                <th>Ticket Price (Rs.)</th>
                <th>Count</th>
                <th>Reserve Ticket</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ticketList" items="${ticketList}">
                <tr>
                    <form action="TicketRecerve" method="post" onsubmit="return validateCount()">
                        <input type="hidden" id="ticketID" name="ticketID" value="<c:out value="${ticketList.ticketID}" />" />
                        <td><c:out value="${ticketList.ticketType}" /></td>
                        <td><c:out value="${ticketList.price}" /></td>
                        <td><input type="number" id="count" name="count" required></td>
                        <td><input type="submit" value="Reserve Ticket"></td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function validateCount() {
            var countField = document.getElementById("count");
            var countValue = parseInt(countField.value);
            
            // Check if the count is a positive integer
            if (countValue <= 0 || isNaN(countValue)) {
                alert("Please enter a valid count (a positive integer).");
                countField.focus();
                return false;
            }

            return true; // Form will be submitted
        }
    </script>
</body>
</html>