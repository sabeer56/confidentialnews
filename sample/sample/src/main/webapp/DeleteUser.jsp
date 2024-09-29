<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
    <style>
         body {
            font-family: Arial, sans-serif;
            background-image: url(https://cdn.pixabay.com/photo/2023/12/09/23/34/login-8440426_1280.png);
            background-repeat: no-repeat;
            background-size: cover;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-image: url(https://media.istockphoto.com/id/1177980696/vector/abstract-grey-and-white-tech-geometric-corporate-design-background-eps-10-vector-illustration.jpg?s=612x612&w=0&k=20&c=c5GJdHR1IhWJQ8K5QoY6iVgcG6L7udwtVpQRQHmI0xk=);
            background-repeat: no-repeat;
            background-size: cover;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }

        button, a {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #2d2e2f;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 13px;
        }

        button:hover, a:hover {
            background-color: #1a1b1c;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Detele User</h2>
    <form id="deleteUserForm">
        <input type="text" id="username" name="username" placeholder="Enter your username" required>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
        <button type="button" onclick="deleteUser()">Delete</button>
    </form>
    <a href="/home">Back</a>
</div>

<script>
    function deleteUser() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        var data = {
            "username": username,
            "password": password
        };

        fetch("/deleteuserrun", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error("Network response was not ok.");
        })
        .then(data => {
            // Display a success message
            alert(data); // You can replace this with a more user-friendly message display mechanism
            // Redirect to the appropriate page if needed
            window.location.href = "/home"; // Redirect to the home page after successful deletion
        })
        .catch(error => {
            console.error("There was a problem with the request:", error);
            // Handle errors, e.g., display an error message to the user
            alert("There was a problem with the request. Please try again later.");
        });
    }
</script>


</body>
</html>
