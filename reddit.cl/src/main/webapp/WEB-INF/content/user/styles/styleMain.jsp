<%--
  Created by IntelliJ IDEA.
  User: Marianna Dudzinska
  Date: 2019-12-07
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background-color: hotpink;
        }

        .topnav {
            overflow: hidden;
            background-color: #e9e9e9;
        }

        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #2196F3;
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
            background-color: grey;
            color: white;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .right-navbar button:hover {
            background-color: deeppink;
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
            background-color: deeppink;
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

        /* Main column */
        .main {
            -ms-flex: 60%; /* IE10 */
            width: 60%;
            background-color: pink;
            padding: 20px;
            margin-left: auto;
            margin-right: auto;

        }

        .postPlace {
            width: 120%;
            background-color: hotpink;
            overflow: visible;
            margin-left: -50px;
            margin-right: -90px;

        }

        /* Fake image, just for this example */
        .fakeimg {
            background-color: #aaa;
            width: 100%;
            padding: 20px;
        }

        .postImage{
            width: 90%;
            padding: 5px;
            margin-left: 5%;
            margin-right: 5%;
        }
        .postDiv {
            padding: 5px;
        }

        .backgroundDiv {
            background-color: hotpink;
        }

        table, th, td {
            border: 1px solid black;
        }

    </style>
</head>
<body>

</body>
</html>
