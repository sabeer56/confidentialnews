<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            background-image: url(https://cdn.pixabay.com/photo/2023/12/09/23/34/login-8440426_1280.png);
            background-repeat: no-repeat;
            background-size: cover;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .signin-container {
            background-image: url(https://media.istockphoto.com/id/1177980696/vector/abstract-grey-and-white-tech-geometric-corporate-design-background-eps-10-vector-illustration.jpg?s=612x612&w=0&k=20&c=c5GJdHR1IhWJQ8K5QoY6iVgcG6L7udwtVpQRQHmI0xk=);
            background-repeat: no-repeat;
            background-size: cover;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            height: 50%;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #000000;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        a{
            text-decoration: none;
            font-size: 13px;
            padding: 7px;
            padding-left: 22.5px;
            padding-right: 22.5px;
            background-color: #000000;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="signin-container">
    <h2>Sign In as Admin</h2>
    <form action="saveadmin" method="post" onsubmit="return validateForm()" >
        <input type="text" id="email" name="email" placeholder="Email ID" required>
        <input type="text" id="pno" name="pno" placeholder="Phone Number" required>
        <input type="text" id="username" name="username" placeholder="Username" required>
        <input type="password" id="password" name="password" placeholder="Password" required>

        <button type="submit">Sign In</button>
    </form>
    <a href="/home">Back</a>
</div>

<script>
    function validateForm() {
        var email = document.getElementById("email").value;
        var pno = document.getElementById("pno").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        if (email === "") {
            alert("Email must be filled out");
            return false;
        }

        if (isNaN(pno) || pno.length !== 10) {
            alert("Invalid phone number");
            return false;
        }

        var passw = /^[A-Za-z]\w{7,14}$/;
        if (!passw.test(password)) {
            alert('Incorrect password format, try another...');
            return false;
        }

        return true;
    }
</script>

</body>
</html>