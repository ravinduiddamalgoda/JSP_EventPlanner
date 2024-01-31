<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Services</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <h1 class="text-3xl font-bold mx-6 my-4">Select Service</h1>

    <!-- Search input field -->
    <input type="text" id="serviceSearch" placeholder="Search by Service Type" class="mx-6 my-4 p-2 border border-gray-300 rounded-lg" />

    <div class="grid grid-cols-4 gap-4 mt-4 mx-6">
        <c:forEach var="serviceList" items="${serviceList}">
            <div class="p-4 border border-gray-300 rounded-lg">
                <h3 class="text-xl font-semibold"><c:out value="${serviceList.serviceName}" /></h3>
                <h6 class="text-sm text-gray-600"><c:out value="${serviceList.serviceType}" /></h6>
                <p class="mt-2"><c:out value="${serviceList.serviceDescription}" /></p>
                <div class="mt-4 flex flex-col space-y-2">
                    <form action="RequestService" method="post">
                        <input type="hidden" id="serviceID" name="serviceID" value="<c:out value="${serviceList.serviceID}" />" />
                        <input type="submit" value="Request" class="bg-blue-500 text-white font-semibold py-1 px-2 rounded-lg">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <script>
        // Get the search input element
        var serviceSearchInput = document.getElementById("serviceSearch");

        // Add an event listener to filter services when the user types in the search input
        serviceSearchInput.addEventListener("input", function () {
            var filter = serviceSearchInput.value.toLowerCase();
            var serviceContainers = document.querySelectorAll(".grid > div");

            serviceContainers.forEach(function (container) {
                var serviceName = container.querySelector("h6").textContent.toLowerCase();

                if (serviceName.includes(filter)) {
                    container.style.display = "block";
                } else {
                    container.style.display = "none";
                }
            });
        });
    </script>
</body>

</html>