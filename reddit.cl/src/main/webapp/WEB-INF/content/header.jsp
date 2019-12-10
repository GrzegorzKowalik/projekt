<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marianna Dudzinska
  Date: 2019-11-26
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<s:include value="language_pack.js"/>--%>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <s:include value="user/styles/styleHead.jsp" />
</head>
<body>
<s:set var="hasRole">${param.hasRole}</s:set>
<div class="topnav">
    <a id="namespace"><b>reddit.cl</b> </a>
    <a class="active" href="#home"><b>Home</b></a>
    <a href="#memes"><b>Memes</b></a>
    <a href="#category2"><b>FUN</b></a>
   <%-- <a href="#category3">category3</a>
    <input type="text" placeholder="Search" name="search">--%>

    <div class="right-navbar">
        <s:if test="#hasRole">
            <button onclick="location.href ='/reddit_cl_war_exploded/log-out.cl'" style="width:auto;">Logout</button>
            <button onclick="location.href ='/reddit_cl_war_exploded/upload.cl'" style="width:auto;">Upload</button>
        </s:if>
        <s:else>
            <button onclick="location.href ='/reddit_cl_war_exploded/login.cl'" style="width:auto;">Login</button>
            <button onclick="location.href ='/reddit_cl_war_exploded/register.cl'" style="width:auto">Register</button>
        </s:else>
    </div>
</div>
</body>
</html>
