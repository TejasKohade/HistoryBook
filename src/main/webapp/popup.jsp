<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("heading") %> Successful </title>
    <style>
        body{
            background-image: url(./images/wallpaperflare.com_wallpaper.jpg);
        }
        .pop-up{
            width: 400px;
            background: #fff;
            border-radius: 6px;
            position: absolute;
            top:50%;
            left:50%;
            transform: translate(-50%,-50%);
            text-align: center;
            padding: 0 30px 30px;
            color:#333;
        }
        .pop-up img{
            width: 100px;
            margin-top: -50px;
            border-radius: 50%;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        .pop-up h2{
            font-size: 38px;
            font-weight: 500;
            margin: 30px 0 10px;
        }
        .pop-up button{
            width: 100%;
            margin-top: 50px;
            padding: 10px 0;
            background: #853c16;
            color: #fff;
            border: 0;
            outline: none;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
            box-shadow: 0 5px 5px rgba(0,0,0,0.2);
        }
        p{
            font-size: 25px;
        }
    </style>
</head>
<body>
    <form action="backtoPanel" class="pop-up" method="get">
        <img src="./images/404-tick.png" alt="">
        <h2>Thank You!</h2>
        <p>Data <%= request.getAttribute("heading") %>d successfully. Thanks!</p>
        <button type="submit">OK</button>
    </form>
</body>
</html>