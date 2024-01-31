<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket Booking</title>
    <style>
      
        
       body {
            font-family: 'Poppins', sans-serif;
            background: #E4F1FF; /* Set the background color to #E4F1FF */
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            font-size: 3.5rem;
            color: #27005D;
            margin: 20px 0;
            text-shadow: 6px 3px 4px rgba(0, 0, 0, 0.2);
        }

        p {
            font-size: 1.2rem;
            color: #333;
            margin: 20px 0;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background: linear-gradient(to bottom, #0077d1, #0077b6);
            color: #fff;
            text-decoration: none;
            border: 2px solid #0077b6;
            border-radius: 10px;
            cursor: pointer;
            margin: 20px;
            margin-left:30px;
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }

        .button:hover {
            background: linear-gradient(to bottom, #005686, #003d5b);
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 20px;
            margin-left:30px;
            margin-bottom:50px;
            border-radius: 50px;
            
        }

        .box {
            border: 4px solid linear-gradient(to bottom, #fff, #f0f0f0) ;
            border-radius: 10px;
            height: 325px;
            width: 400px;
            transition: transform 0.5s;
            background: linear-gradient(to bottom, #fff, #f0f0f0);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
			
        }

        .box:hover {
            transform: scale(1.05);
        }

        h3 {
            text-align: center;
            font-size: 1.8rem;
            margin: 15px 0;
        }

        h6 {
            font-size: 1rem;
            margin: 0;
            margin-left: 30px;
        }

        a {
            text-decoration: none;
            color: #0077b6;
        }

        .blue-button1 {
            display: block;
            width: 150px;
            text-align: center;
            background: linear-gradient(to bottom,#0077d1, #0077b6 );
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            margin: 0 auto;
            margin-top: 15px;
            transition: background 0.3s;
        }

        .blue-button1:hover {
            background: linear-gradient(to bottom, #005686, #003d5b);
        }
    </style>
</head>
<body>
    <h1>Ticket Booking</h1>
    <c:forEach var="user" items="${User}">
        <p style="font-size: 30px; color: #333; font-family: 'Poppins';  margin: 25px ; line-height: 1.5;">Welcome <c:out value="${user.name}" /></p>
        <a href="UserData?userID=<c:out value="${user.userID}" />" class="button">My Account</a>
    </c:forEach>
     <!-- <a href="GetTicketBooked" class="button">View Booked Tickets</a> -->
    <div class="grid">
        <c:forEach var="eventList" items="${eventList}">
            <div class="box">
                <h3><c:out value="${eventList.eventName}" /></h3>
                <h6><c:out value="${eventList.eventType}" /></h6>
                <p style="padding : 10px;"><c:out value="${eventList.eventDescription}" /></p>
                <p style="padding : 10px;">Event Venue : <c:out value="${eventList.eventVenue}" /></p>
                <a href="TicketBooking?eventId=<c:out value="${eventList.eventID}" />" class="blue-button1">Reserve a Ticket</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>