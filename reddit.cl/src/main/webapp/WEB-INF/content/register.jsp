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
</head>
<body>
<h1>Fill the registration form</h1>
<s:form action="/user/sign-in.action">
    <s:textfield name="userDTO.nick" label="Nickname" placeholder="nickname"/>
    <s:textfield name="userDTO.email" label="Email" placeholder="email"/>
    <s:password name="userDTO.password" label="Password" placeholder="password"/>
    <s:submit value="Sign-in"/>
</s:form>
</body>
</html>