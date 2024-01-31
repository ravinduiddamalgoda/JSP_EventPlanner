<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Event</title>
    <script src="https://cdn.tailwindcss.com"></script>
      <style>
       @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
       *{
       		font-family: 'poppins';
       	
       }
    </style>
    <script>
    function validateForm() {
        var eventName = document.getElementById("eventName").value;
        var eventType = document.getElementById("eventType").value;
        var eventDescription = document.getElementById("eventDescription").value;
        var eventVenue = document.getElementById("eventVenue").value;
        var evtDate = document.getElementById("evtDate").value;

        if (eventName === "" || eventType === "" || eventDescription === "" || eventVenue === "" || evtDate === "") {
            alert("All fields are required");
            return false;
        }

        // Validate the date format
        var dateRegex = /^\d{4}-\d{2}-\d{2}$/;
        if (!dateRegex.test(evtDate)) {
            alert("Date must be in the format yyyy-MM-dd");
            return false;
        }

        // Get the current date
        var currentDate = new Date();
        
        // Convert the current date to yyyy-MM-dd format
        var currentDateString = currentDate.toISOString().split('T')[0];
        
        // Check if the entered date is a future date
        if (evtDate <= currentDateString) {
            alert("Please select a future date");
            return false;
        }

        return true;
    }
    </script>
</head>
<body class="bg-blue-100">
    <div class="container mx-auto p-6 w-96">
        <h2 class="text-3xl font-bold mb-6 text-center ">Add Event</h2>
        <form action="AddEvent" method="POST" onsubmit="return validateForm()" class="bg-white rounded-lg p-6 shadow-md">
            <div class="mb-4">
                <label for="eventName" class="block text-gray-700 font-bold mb-2 ">Event Name:</label>
                <input type="text" id="eventName" name="eventName" class="w-full px-3 py-2 border rounded-lg">
            </div>

            <div class="mb-4">
                <label for="eventType" class="block text-gray-700 font-bold mb-2 ">Event Type:</label>
                <select id="eventType" name="eventType" class="w-full px-3 py-2 border rounded-lg">
                    <option value="Music and DJ">Music and DJ</option>
                    <option value="Wedding">Wedding</option>
                    <option value="Seminar">Seminar</option>
                    <option value="Get to Gather">Get to Gather</option>
                    <option value="Funeral">Funeral</option>
                    <option value="Conference">Conference</option>
                    <option value="Food Festival">Food Festival</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="mb-4">
                <label for="eventDescription" class="block text-gray-700 font-bold mb-2 ">Event Description:</label>
                <textarea id="eventDescription" name="eventDescription" class="w-full px-3 py-2 border rounded-lg"></textarea>
            </div>

            <div class="mb-4">
                <label for="eventVenue" class="block text-gray-700 font-bold mb-2">Event Venue:</label>
                <input type="text" id="eventVenue" name="eventVenue" class="w-full px-3 py-2 border rounded-lg">
            </div>

            <div class="mb-4">
                <label for="evtDate" class="block text-gray-700 font-bold mb-2">Event Date:</label>
                <input type="date" id="evtDate" name="evtDate" class="w-full px-3 py-2 border rounded-lg">
            </div>

            <button type="submit" class="bg-blue-500 text-white font-bold py-2 px-4 rounded-lg hover:bg-blue-700 mx-auto block">Submit</button>
        </form>
    </div>
</body>
</html>