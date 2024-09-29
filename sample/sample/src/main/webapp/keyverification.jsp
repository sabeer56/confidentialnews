<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Access Key</title>
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
    <form id="loginForm" action="/keyverification" method="get">
        <input type="text" name="key" id="key" placeholder="Enter the Access key" required>
        <button type="submit">View News</button>
    </form>
    <a href="/login">Back</a>
    </div> 
</body>
</html>
