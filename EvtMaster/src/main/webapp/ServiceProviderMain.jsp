<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service Provider</title>
 <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <nav class="bg-blue-500 p-4 text-white">
        <div class="container mx-auto flex justify-between items-center">
            <div>
                <a href="#" class="text-lg font-bold">Service Provider</a>
            </div>
            <ul class="flex space-x-4">
                <li><a href="add-service.jsp" class="hover:underline">Add Service</a></li>
                <li><a href="GetRequest" class="hover:underline">View Requests</a></li>
                <li><a href="logout.jsp" class="hover:underline">Logout</a></li>
            </ul>
        </div>
    </nav>
    <h1 class="text-3xl font-semibold mt-6 ml-6">Your Services</h1>
    <div class="container mx-auto mt-4">
        <table class="min-w-full bg-white rounded-lg shadow-lg">
            <thead>
                <tr>
                    <th class="text-gray-600 uppercase text-md leading-normal">Service Name</th>
                    <th class="text-gray-600 uppercase text-md leading-normal">Service Type</th>
                    <th class="text-gray-600 uppercase text-md leading-normal">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="service" items="${service}">
                    <tr>
                        <td class="px-6 py-4 whitespace-nowrap"><c:out value="${service.serviceName}" /></td>
                        <td class="px-6 py-4 whitespace-nowrap"><c:out value="${service.serviceType}" /></td>
                        <td class="px-6 py-4 whitespace-nowrap">
                            <form action="DeleteService" method="post" class="inline">
                                <input type="hidden" id="serviceID" name="serviceID" value="<c:out value="${service.serviceID}" />" />
                                <button class="bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-4 rounded-lg">Delete Service</button>
                            </form>
                            <c:choose>
                                <c:when test="${service.availableStatus == false}">
                                    <form action="StatusAvailable" method="post" class="inline ml-2">
                                        <input type="hidden" id="serviceID" name="serviceID" value="<c:out value="${service.serviceID}" />" />
                                        <button class="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded-lg">Make Available</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="StatusUnAvailable" method="post" class="inline ml-2">
                                        <input type="hidden" id="serviceID" name="serviceID" value="<c:out value="${service.serviceID}" />" />
                                        <button class="bg-gray-500 hover:bg-gray-600 text-white font-semibold py-2 px-4 rounded-lg">Make Unavailable</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
