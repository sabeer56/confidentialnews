<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="edu.jsp.ak.Dto.NewsData" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Latest News</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=DM+Serif+Display:ital@1&display=swap');
        body {
            font-family: 'DM Serif Display', serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* Ensures footer sticks to bottom */
        }

        header {
            background-color: #000000;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav {
            position: sticky;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000; /* Ensures it's above other content */
            background-color: #000000;
            overflow: hidden;
        }

        nav a {
            float: right;
            display: block;
            color: #fff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        nav a:hover {
            background-color: #ddd;
            color: #333;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            width: 100%;
        }

        .news-list {
        list-style-type: none;
        padding: 0;
        margin: 20px 0;
        flex-grow: 1;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .news-item {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        margin-bottom: 20px;
        text-align: center;
        max-width: 80%;
        width: 100%; /* Ensures each item takes full width */
        display: flex;
        flex-direction:column;
        align-items: center;
        justify-content: center;
    }

    .news-item-image-container {
        max-width: 70%;
        border-radius: 10px;
        margin-bottom: 10px;
        overflow: hidden;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .news-item img {
        width: 70%;
        height: auto;
        display: block;
    }
    </style>
</head>
<body>

<header>
    <img src="" alt="">
    <h1>Confidential News</h1>
</header>

<nav>
    <a href="home">Home</a>
</nav>

<ol class="news-list">
        <% List<NewsData> news = (List<NewsData>) request.getAttribute("newses"); %>
    <% if (news != null) { %>
    <% for (int i = news.size() - 1; i >= 0; i--) { %>
        <li class="news-item" id="news_<%= news.get(i).getId() %>">
            <!-- Existing content -->
            <h3><%= news.get(i).getHeading() %></h3>
            <div class="news-item-image-container">
                <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(news.get(i).getImageData()) %>" alt="News Image">
            </div>
            <p><%= news.get(i).getParagraph() %></p>
            <p><%= news.get(i).getCreatedAt() != null ? new SimpleDateFormat("dd-MM-yyyy HH:mm").format(news.get(i).getCreatedAt()) : "Date not available" %></p>
        </li>
    <% } %>
<% } else { %>
    <p>No news available</p>
<% } %>
    </ol>

<footer>
    <p>&copy; <%= new java.util.Date().getYear() + 1900 %> Our Website. All rights reserved.</p>
</footer>
</body>
</html>
