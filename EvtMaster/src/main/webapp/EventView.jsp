<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Event Planner</title>
    <script>
        function navigateToAddEventPage() {
            // Change the current page's location to AddEvent.jsp
            window.location.href = 'AddEvent.jsp';
        }
        function navigateToRequestServicePage() {
            // Change the current page's location to AddEvent.jsp
            window.location.href = 'RequestService.jsp';
        }
    </script>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-blue-100">
    <section class="container mx-auto p-4">
        <h1 class="text-3xl font-bold">Welcome <c:out value="${EPData.name}" /></h1>

        <button onclick="navigateToAddEventPage()" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded-lg mt-4">Add Event</button>
		<button class="bg-blue-500 text-white font-semibold py-2 px-4 rounded-lg mt-4"> <a href="GetServices">Request a Service </a> </button>
        <div class="grid grid-cols-4 gap-4 mt-4">
            <c:forEach var="eventList" items="${eventList}">
                <div class="p-4 border border-gray-300 rounded-lg">
                    <h3 class="text-xl font-semibold"><c:out value="${eventList.eventName}" /></h3>
                    <h6 class="text-sm text-gray-600"><c:out value="${eventList.eventType}" /></h6>
                    <p class="mt-2"><c:out value="${eventList.eventDescription}" /></p>
                    <p class="mt-2">Event Venue: <c:out value="${eventList.eventVenue}" /></p>
                    <div class="mt-4 flex flex-col space-y-2">
                        <c:if test="${!eventList.enableTicketBooking}">
                            <form action="UnableTKBooking" method="post">
                                <input type="hidden" id="eventID" name="eventID" value="<c:out value="${eventList.eventID}" />" />
                                <input type="submit" value="Enable Ticket Booking"
                                       class="bg-blue-500 text-white font-semibold py-1 px-2 rounded-lg">
                            </form>
                        </c:if>
                        <c:if test="${eventList.enableTicketBooking}">
                            <form action="DesableTKBooking" method="post">
                                <input type="hidden" id="eventID" name="eventID" value="<c:out value="${eventList.eventID}" />" />
                                <input type="submit" value="Disable Ticket Booking"
                                       class="bg-red-500 text-white font-semibold py-1 px-2 rounded-lg">
                            </form>
                        </c:if>
                        <form action="DeleteEvent" method="post">
                            <input type="hidden" id="eventID" name="eventID" value="<c:out value="${eventList.eventID}" />" />
                            <input type="submit" value="Delete Event"
                                   class="bg-red-500 text-white font-semibold py-1 px-2 rounded-lg">
                        </form>
                        <!-- 
                        <form action="addTicket.jsp" method="post">
						    <input type="hidden" id="eventID" name="eventID" value="<c:out value="${eventList.eventID}" />" />
						    <input type="submit" value="Add Ticket" class="bg-blue-500 text-white font-semibold py-1 px-2 rounded-lg">
						</form>
                         -->
                        
                         

                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</body>

</html>