<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 03.11.2019
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<style type="text/css">
    .errorMessage {
        background-color:#FFCCCC;
        border:1px solid #CC0000;
        width:400px;
        margin-bottom:8px;
    }
</style>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <s:include value="language_pack.js"/>
</head>
<body>
<jsp:include page="user/styles/styleHead1.jsp" />
<%--<span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>--%>
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
</body>
</html>
