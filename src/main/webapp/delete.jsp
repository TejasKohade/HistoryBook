<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete</title>
    <style>
    @import url("https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@300&display=swap");
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-image: url(./images/wallpaperflare.com_wallpaper.jpg);
            color: #fff;
            font-family: "Be Vietnam Pro", sans-serif;
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
            width: 450px;
            height: 500px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            background-color: #853c16;
            padding: 25px 25px;
            display: flex;
            flex-direction: column;
        }

        .delete-form p {
            text-align: center;
            font-weight: 500;
            font-size: 30px;
            margin-top: 20px;
        }

        .insert-form {
            margin-top: 50px;
            margin-bottom: 40px;
            width: 400px;
            border: 0;
            border-bottom: 2px solid #f0d2d2;
            outline: 0;
            font-size: 1.2rem;
            color: #fff;
            background-color: #fff;
            padding: 7px 0;
            background: transparent;
        }

        ::placeholder {
            color: #d7d3d3;
        }

        .my-btn {
            margin-left: 35%;
            margin-right: 40%;
            margin-top: 20px;
            cursor: pointer;
            width: 28.5%;
            height: 3em;
            position: relative;
            font-size: 17px;
            top: 11px;
            background-color: #be843c;
            border-radius: 25px;
            border: none;
            color: rgb(244, 242, 242);
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <div class="container">
            <form class="delete-form" action="DeleteServlet" method="get">
                <p>Delete Record</p>
                <input type="text" name="title" class="insert-form" placeholder="Enter title of the record to delete" />
                <button type="submit" class="my-btn">Delete</button>
            </form>
        </div>
    </div>
</body>
</html>