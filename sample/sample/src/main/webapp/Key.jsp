<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Access Key</title>
    <style>
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
        
        .access-container {
            background-color: tomato;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        a {
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
        a:hover {
            background-color: #1a1b1c;
        }
    </style>
</head>
<body>
    <div class="login-container">
    <h2>Your Access Key</h2>
    <div class="access-container">
        <h1>AzKm162</h1>
    </div>
    <a href="/home">Home</a>
    <a href="/newsdata">Add News</a>
    <a href="/newsadmin">View News</a>
    </div> 
</body>
</html>
