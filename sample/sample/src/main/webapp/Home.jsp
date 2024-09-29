<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=DM+Serif+Display:ital@1&display=swap');
        body {
            font-family: 'DM Serif Display', serif;
            margin: 0;
            padding: 0;
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
            z-index: 1000;
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
        
        .container {
            text-align: center;
            padding: 20px;
        }

        .button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            background-color: #4a8bdf;
            color: #fff;
            margin: 10px;
            text-decoration: none;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .About {
            width: 70%;
            background-color: tomato;
            background-image: url(https://media.istockphoto.com/id/1177980696/vector/abstract-grey-and-white-tech-geometric-corporate-design-background-eps-10-vector-illustration.jpg?s=612x612&w=0&k=20&c=c5GJdHR1IhWJQ8K5QoY6iVgcG6L7udwtVpQRQHmI0xk=);
            background-repeat: no-repeat;
            background-size: cover;
            border-radius: 40px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            margin: 30px auto; 
            justify-content: center;
            align-items: center;
            display: flex;
            flex-direction: column;
        }
    </style>
</head>
<body id="Home">

<header>
    <img src="" alt="">
    <h1>Confi News</h1>
</header>

<nav>
    <a href="#Home">Home</a>
    <a href="login">Login</a>
    <a href="signin">SignIn</a>
    <a href="#about">About</a>
</nav>

<div class="container">
    <h2>Welcome to Confi</h2>
    <p>Confidential News is your trusted source for the latest news and updates. Sign in or log in to access exclusive content.</p>
    <a class="button" href="signin">Sign In</a>
    <a class="button" href="login">Login</a>
</div>

<div id="about" class="About">
    <h2>About</h2>
    <p>A confidential news application stands as a digital sanctuary for users seeking to consume information without compromising their privacy. In an era where data breaches and surveillance are rampant, this platform emerges as a beacon of trust and security. It operates on the principle of end-to-end encryption, ensuring that every communication and interaction remains shielded from prying eyes. Users can access a diverse array of news articles, reports, and updates, knowing that their browsing history and preferences are kept confidential.</p>
    <p>Beyond its encryption prowess, the confidential news application fosters a community of informed individuals, offering a space where discussions flourish without fear of censorship or surveillance. Users can engage in meaningful dialogue, share insights, and explore diverse perspectives without sacrificing their anonymity. The platform's commitment to user privacy extends to its data handling practices, where personal information remains strictly confidential and protected from exploitation.</p>
    <p>Moreover, the confidential news application empowers users to reclaim control over their digital footprint. By prioritizing privacy and security, it challenges the status quo of data-centric models that commodify user information. In doing so, it sets a new standard for ethical journalism and responsible technology. As society grapples with the implications of digital surveillance, this platform stands as a testament to the enduring value of privacy in the digital age.</p>
</div>

<footer>
    <p>&copy; 2024 Our Website. All rights reserved.</p>
</footer>

</body>
</html>
