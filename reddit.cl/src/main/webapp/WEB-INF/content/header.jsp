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
    <jsp:include page="user/styles/styleHead.jsp" />
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
