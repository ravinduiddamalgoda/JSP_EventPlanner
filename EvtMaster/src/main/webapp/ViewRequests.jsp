<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Service Requests</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <nav class="bg-blue-500 p-4 text-white">
        <div class="container mx-auto flex justify-between">
            <div>
                <a href="ServiceProviderMain.jsp" class="text-lg font-bold">Service Provider</a>
            </div>
            <ul class="flex space-x-4">
                <li><a href="add-service.jsp" class="hover:underline">Add Service</a></li>
                <li><a href="GetRequest" class="hover:underline">View Requests</a></li>
                <li><a href="logout.jsp" class="hover:underline">Logout</a></li>
            </ul>
        </div>
    </nav>
    <div class="container mx-auto p-6">
        <h1 class="text-2xl font-semibold mb-4">Service Requests</h1>
        <table class="w-full border-collapse border border-gray-200">
            <thead>
                <tr>
                    <th class="bg-gray-200 p-3">Event Planner Name</th>
                    <th class="bg-gray-200 p-3">Event Planner Email</th>
                    <th class="bg-gray-200 p-3">Service Name</th>
                    <th class="bg-gray-200 p-3">Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="SR" items="${sr}">
                    <tr>
                        <td class="p-3"><c:out value="${SR.eventPlannerName}" /></td>
                        <td class="p-3"><c:out value="${SR.eventPlannerEmail}" /></td>
                        <td class="p-3"><c:out value="${SR.serviceName}" /></td>
                        <td class="p-3">
                            <c:if test="${SR.status == false}">
                                <form action="AcceptRequest" method="post">
                                    <input type="hidden" id="requestId" name="requestId" value="<c:out value="${SR.requestId}" />" />
                                    <button class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded-full">Accept</button>
                                </form>
                            </c:if>
                            <c:if test="${SR.status == true}">
                                <form action="" method="post">
                                    <button class="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded-full">Accepted</button>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
