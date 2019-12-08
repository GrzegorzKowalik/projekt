<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 03.11.2019
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <s:include value="language_pack.js"/>
</head>
<body>
<jsp:include page="user/styles/styleHead.jsp" />
<%--<span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>--%>
<form class="modal-content" action='<s:url action="sign-in"/>' method="post">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label><b>Email</b></label>
        <s:fielderror fieldName="userDTO.email"/>
        <input type="text" placeholder="Enter Email" name="userDTO.email" required>

        <label><b>Username</b></label>
        <s:fielderror fieldName="userDTO.nick"/>
        <input type="text" placeholder="Enter Nickname" name="userDTO.nick" required>

        <label><b>Password</b></label>
        <s:fielderror fieldName="userDTO.password"/>
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
<%--<h1>Fill the registration form</h1>
<s:form action="sign-in.action">
    <s:textfield name="userDTO.nick" label="Nickname" placeholder="nickname"/>
    <s:textfield name="userDTO.email" label="Email" placeholder="email"/>
    <s:password name="userDTO.password" label="Password" placeholder="password"/>
    <s:submit value="Sign-in"/>
</s:form>--%>
</body>
</html>
