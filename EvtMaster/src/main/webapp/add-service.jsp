<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Service</title>
<script src="https://cdn.tailwindcss.com"></script>
   <script>
        function validateForm() {
            var serviceName = document.getElementById("serviceName").value;
            var serviceType = document.getElementById("serviceType").value;
            var serviceDescription = document.getElementById("serviceDescription").value;
            
            if (serviceName === "") {
                alert("Service Name is required");
                return false;
            }
            
            if (serviceType === "") {
                alert("Service Type is required");
                return false;
            }
            
            if (serviceDescription === "") {
                alert("Service Description is required");
                return false;
            }
            
            return true;
        }
    </script>
</head>
<body class="bg-gray-100 p-6">
    <div class="container mx-auto max-w-md bg-white rounded-lg shadow-md p-6">
        <h2 class="text-2xl font-semibold mb-4">Add Service</h2>
        <form action="AddService" method="POST" onsubmit="return validateForm()" class="space-y-4">
            <div class="flex flex-col">
                <label for="serviceName" class="text-gray-600">Service Name:</label>
                <input type="text" id="serviceName" name="serviceName" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
            </div>
            <div class="flex flex-col">
                <label for="serviceType" class="text-gray-600">Service Type:</label>
                <select id="serviceType" name="serviceType" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
                    <option value="Catering">Catering</option>
                    <option value="DJ and Music">DJ and Music</option>
                    <option value="Decoration">Decoration</option>
                    <option value="Function Equipment Rent">Function Equipment Rent</option>
                    <option value="Function Equipment Rent">Dancing Teams</option>
                    <option value="Function Equipment Rent">Lightning</option>
                    <option value="Function Equipment Rent">Vehicle Rent</option>
                </select>
            </div>
            <div class="flex flex-col">
                <label for="serviceDescription" class="text-gray-600">Service Description:</label>
                <textarea id="serviceDescription" name="serviceDescription" required class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300"></textarea>
            </div>
            <div class="flex flex-col">
                <label for="availableStatus" class="text-gray-600">Available Status:</label>
                <select id="availableStatus" name="availableStatus" class="px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:border-blue-300">
                    <option value="true">Available</option>
                    <option value="false">Not Available</option>
                </select>
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 rounded-lg px-2">Add Service</button>
        </form>
    </div>
</body>

</html>