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
    <s:include value="user/styles/styleHead.jsp" />
</head>
<body>
<s:set var="hasRole">${param.hasRole}</s:set>
<div class="topnav">
    <a id="namespace"> reddit.cl </a>
    <a class="active" href="#home">Home</a>
    <a href="#memes">Memes</a>
    <a href="#category2">category2</a>
    <a href="#category3">category3</a>
    <input type="text" placeholder="Search" name="search">

    <div class="right-navbar">
        <s:if test="#hasRole">
            <button onclick="location.href ='<s:url action="log-out"/>'" style="width:auto;">Logout</button>
            <button onclick="location.href ='<s:url action="upload"/>'" style="width:auto;">Upload</button>
        </s:if>
        <s:else>
            <button onclick="location.href ='<s:url action="login"/>'" style="width:auto;">Login</button>
            <button onclick="location.href ='<s:url action="register"/>'" style="width:auto">Register</button>
        </s:else>
    </div>
</div>
</body>
</html>
