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
    <s:include value="user/styles/styleMain2.jsp" />
</head>
<body>
<jsp:include page="user/styles/styleHead.jsp" />
<%--<span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>--%>
<form class="modal-content" action='<%=request.getContextPath()%>/log-in.cl' method="post">
    <div class="container">
        <h1>Log in</h1>
        <hr>
        <label><b>Email</b></label>
        <s:fielderror fieldName="userDTO.email"/>
        <input type="text" placeholder="Enter email" name="userDTO.email" required>

        <label><b>Password</b></label>
        <s:fielderror fieldName="userDTO.password"/>
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
