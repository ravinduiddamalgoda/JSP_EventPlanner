<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View My Tickets</title>
</head>
<body>
<body>
    <h1>View Ticket</h1>
    <table>
        <thead>
            <tr>
                <th>Ticket ID</th>
                <th>Count</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="BookedTicket" items="${BookedTicket}">
                <tr>
                    <form action="UpdateTicketRecerve" method="post">
                        <input type="hidden" id="ticketID" name="ticketID" value="<c:out value="${BookedTicket.ticketID}" />" />                       
                        <td><input type="number" id="count" name="count" value="<c:out value="${BookedTicket.count}" />" /></td>
                        <td><input type="submit" value="Update Count"></td>
                    </form>
                    <form action="DeleteTicketRecerve" method="post">
                        <input type="hidden" id="ticketID" name="ticketID" value="<c:out value="${BookedTicket.ticketID}" />" />                                             
                        <td><input type="submit" value="Delete Reservation"></td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>



</body>
</html>