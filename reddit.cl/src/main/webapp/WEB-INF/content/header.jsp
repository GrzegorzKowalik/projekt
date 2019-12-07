<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marianna Dudzinska
  Date: 2019-11-26
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:include value="language_pack.js"/>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            background-color: #333;
            overflow: hidden;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        /* Change the color of links on hover */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Add an active class to highlight the current page */
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }

        .topnav .right-navbar {
            float: right;
        }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: none;
            width:120px;
        }

        .topnav .right-navbar button {
            float: right;
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background-color: #555;
            color: white;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .right-navbar button:hover {
            background-color: green;
        }

        @media screen and (max-width: 600px) {
            .topnav .right-navbar {
                float: none;
            }
            .topnav a, .topnav input[type=text], .topnav .right-navbar button {
                float: none;
                display: block;
                text-align: left;
                width: 100%;
                margin: 0;
                padding: 14px;
            }
            .topnav input[type=text] {
                border: 1px solid #ccc;
            }
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        /* Add a background color when the inputs get focus */
        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Set a style for all buttons */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        button:hover {
            opacity:1;
        }

        /* Extra styles for the cancel button */
        .cancelbtn {
            padding: 14px 20px;
            background-color: #f44336;
        }

        /* Float cancel and signup buttons and add an equal width */
        .cancelbtn, .signupbtn {
            float: left;
            width: 50%;
        }
        .loginbtn {
            width: 40%;
            margin-left: 30%;
            margin-right: 30%
        }

        /* Add padding to container elements */
        .container {
            padding: 16px;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: #474e5d;
            /*padding-top: 50px;*/
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 50%; /* Could be more or less, depending on screen size */
        }

        /* Style the horizontal ruler */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* The Close Button (x) */
        .close {
            position: absolute;
            right: 35px;
            top: 15px;
            font-size: 40px;
            font-weight: bold;
            color: #f1f1f1;
        }

        .close:hover,
        .close:focus {
            color: #f44336;
            cursor: pointer;
        }

        /* Clear floats */
        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }

        /* Change styles for cancel button and signup button on extra small screens */
        @media screen and (max-width: 300px) {
            .cancelbtn, .signupbtn {
                width: 100%;
            }
        }
        /* Header/logo Title */
        .header {
            padding: 80px;
            text-align: center;
            background: #1abc9c;
            color: white;
        }

        /* Increase the font size of the heading */
        .namespace {
            font-size: 40px;
        }
    </style>
</head>
<body>
<div class="topnav">
    <a id="namespace"> reddit.cl </a>
    <a class="active" href="#home">Home</a>
    <a href="#memes">Memes</a>
    <a href="#category2">category2</a>
    <a href="#category3">category3</a>
    <input type="text" placeholder="Search" name="search">

    <div class="right-navbar">
        <button onclick="document.getElementById('login').style.display='block'" style="width:auto;">Login</button>
        <button onclick="document.getElementById('register').style.display='block'" style="width:auto">Register</button>
        <button onclick="document.getElementById('upload').style.display='block'" style="width:auto;">Upload</button>
    </div>
</div>

<div id="register" class="modal">
    <span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>
    <form class="modal-content" action='<s:url action="sign-in"/>' method="post">
        <div class="container">
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="userDTO.email" required>

            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Nickname" name="userDTO.nick" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="userDTO.password" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

            <label>
                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>

            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" onclick="document.getElementById('register').style.display='none'" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</div>

<div id="upload" class="modal">
    <span onclick="document.getElementById('upload').style.display='none'" class="close" title="Close Modal">&times;</span>
    <form class="modal-content" action="/action_page.php" method="post">
        <div class="container">
            <h1>Upload</h1>
            <br>
            <label><b>Name</b></label>
            <input type="text" name="nametag" size="20" />

            Select file : <input type='file' name='file' id='file' class='form-control' ><br>

            <div class="clearfix">
                <%--<button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>--%>
                <button type="submit" class="loginbtn">Upload</button>
            </div>
        </div>
    </form>
</div>
<div id="login" class="modal">
    <span onclick="document.getElementById('login').style.display='none'" class="close" title="Close Modal">&times;</span>
    <form class="modal-content" action='<s:url action="log-in"/>' method="post">
        <div class="container">
            <h1>Log in</h1>
            <hr>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter email" name="userDTO.email" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="userDTO.password" required>

            <label>
                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>

            <div class="clearfix">
                <%--<button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>--%>
                <button type="submit" class="loginbtn">Log in</button>
            </div>
        </div>
    </form>
</div>
<script>
    var modal = document.getElementById('register');
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    var modal = document.getElementById('login');
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    var modal = document.getElementById('upload');
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    var placeholder = document.getElementById("e")
</script>
</body>
</html>