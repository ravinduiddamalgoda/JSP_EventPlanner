<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="bg-blue-500 p-4 text-white">
        <div class="container mx-auto flex justify-between">
            <div>
                <a href="#" class="text-lg font-bold">Admin Dashboard</a>
            </div>
            <ul class="flex space-x-4">
              
                <li><a href="AdminRegister.jsp" class="hover:underline">Add Admin</a></li>
                <li><a href="AddSP.jsp" class="hover:underline">Register Service Provider</a></li>
                <li><a href="logout.jsp" class="hover:underline hover:text-red-700">Logout</a></li>
            </ul>
        </div>
    </nav>

	<h1 class="text-3xl font-bold mx-6 my-4">Verify Events</h1>
   <div class="container mx-auto">
        <table class="min-w-full bg-white rounded-lg shadow-lg">
            <thead>
                <tr>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Event Name</th>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Event Type</th>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Event Description</th>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Event Venue</th>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Event Date</th>
                    <th class=" text-gray-600 uppercase text-md leading-normal">Verify Event</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${event}">
                    <tr>
                        <form action="VerifyEvent" method="post">
                            <input type="hidden" id="eventID" name="eventID" value="<c:out value='${event.eventID}' />" />
                            <td class="px-6 py-4 whitespace-nowrap"><c:out value="${event.eventName}" /></td>
                            <td class="px-6 py-4 whitespace-nowrap"><c:out value="${event.eventType}" /></td>
                            <td class="px-6 py-4 whitespace-nowrap"><c:out value="${event.eventDescription}" /></td>
                            <td class="px-6 py-4 whitespace-nowrap"><c:out value="${event.eventVenue}" /></td>
                            <td class="px-6 py-4 whitespace-nowrap"><c:out value="${event.eventDate}" /></td>
                            <td class="px-6 py-4 whitespace-nowrap">
                                <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded-full">Verify Event</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
