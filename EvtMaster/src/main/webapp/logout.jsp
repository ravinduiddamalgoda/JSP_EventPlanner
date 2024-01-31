<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<script>
        if (confirm("Are you sure you want to log out?")) {
            // If the user confirms the logout, perform the logout via AJAX
            logoutUser();
        } else {
            // If the user cancels, you can provide options to stay on the page or navigate elsewhere
        }

        function logoutUser() {
            fetch('/AdminLogout', {
                method: 'POST',
                credentials: 'same-origin' // Include cookies if needed
            })
            .then(response => {
                if (response.status === 200) {
                    // Successful logout, you can redirect or perform other actions
                    window.location.href = 'AdminLogin.jsp'; // Redirect to the login page
                } else {
                    // Handle the logout failure or other status codes
                    window.location.href = 'AdminLogin.jsp'; 
                    console.error('Logout failed');
                }
            })
            .catch(error => {
                // Handle network or request errors
                console.error('Error:', error);
            });
        }
    </script>

</body>
</html>