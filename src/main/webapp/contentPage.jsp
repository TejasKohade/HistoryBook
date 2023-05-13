<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("heading") %></title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    color: white;
    background-image: url(./images/wallpaperflare.com_wallpaper.jpg);
}

#wrapper {
    width: 100vw;
    height: 100vh;
    color: #fff;
    letter-spacing: 1px;
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
}

.container {
    width: 70%;
    height: 70%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    background-color: #7d3a15;
    padding: 30px 25px;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 1.5rem;
    grid-auto-rows: minmax(100px, auto);
}

.heading {
    grid-column: 2/4;
    grid-row: 1;
}

h1{
    margin-top: 2rem;
}

.photo {
    grid-column: 1;
    grid-row: 1 / 5;
    padding: 25px 15px;
}

.photo img {
    width: 300px;
    height: 400px;
    object-fit: cover;
}

.content {
    grid-column: 2 / 4;
    grid-row: 2 / 5;
}
</style>
</head>
<body>
<div id="wrapper">
        <div class="container">
            <div class="heading">
                <h1><%= request.getAttribute("heading") %></h1>
            </div>
            <div class="photo">
                <img src="<%= request.getAttribute("photo") %>" alt="">
            </div>
            <div class="content">
                <p>
                    <%= request.getAttribute("content") %>
                </p>
            </div>
        </div>
    </div>
</body>
</html>