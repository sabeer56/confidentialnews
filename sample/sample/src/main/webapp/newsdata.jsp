<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Card Form</title>
    <style>
    	.login-container {
            background-image: url(https://media.istockphoto.com/id/1177980696/vector/abstract-grey-and-white-tech-geometric-corporate-design-background-eps-10-vector-illustration.jpg?s=612x612&w=0&k=20&c=c5GJdHR1IhWJQ8K5QoY6iVgcG6L7udwtVpQRQHmI0xk=);
            background-repeat: no-repeat;
            background-size: cover;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width:450px;
            height: 60%;
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
        
        button, a {
            width: 50%;
            padding: 10px;
            margin-bottom: 20px;
            background-color: #2d2e2f;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 13px;
        }
        
        input  {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        
        textarea{
            width: 100%;
            height:145px;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        #image {
        	width: 100%;
        	padding: 10px;
        	background-color: grey;
        	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        	margin: 10px 0;
        	box-sizing: border-box;
        	border: 1px solid #ccc; /* Add border to provide a visual indication */
        	border-radius: 4px; /* Optional: Add rounded corners */
    }
    </style>
    <script>
        function showPopup() {
            alert("Data saved successfully!");
        }
    </script>
</head>
<body>
	<div class="login-container">
    <h2>Enter the Information</h2>
    <form action="/savenews" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
        <input type="text" name="heading" id="heading" placeholder="Enter the Heading"><br>
        <textarea name="paragraph" id="paragraph" placeholder="Enter the news"></textarea><br>
        <input type="file" name="image" id="image" accept="image/*"> <!-- Image receiver -->
        <button type="submit">Add</button>
    </form>
    <a href="/key">Back</a>
    <a href="/newsadmin">View News</a>
</div>

<script>
    function validateForm() {
        var heading = document.getElementById("heading").value.trim();
        var paragraph = document.getElementById("paragraph").value.trim();
        var image = document.getElementById("image");

        // Validation for required fields
        if (heading === "" || paragraph === "") {
            alert("Please fill in all fields.");
            return false;
        }

        // Validation for image size
        if (image.files.length > 0) {
            var fileSize = image.files[0].size; // in bytes
            var maxSize = 100 * 1024; 

            if (fileSize > maxSize) {
                alert("Image size exceeds the maximum allowed size of 100KB.");
                return false;
            }
        }

        return true; // Form submission proceeds if all validations pass
    }
</script>


</body>
</html>