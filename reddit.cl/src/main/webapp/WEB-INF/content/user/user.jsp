<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 19.10.2019
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>REDDIT.CL</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <s:include value="user/styles/styleMain2.jsp" />
   <%-- <s:include value="user/styles/styleHead.jsp" />--%>
</head>
<body>
<s:include value="../header.jsp">
  <s:param name="hasRole"><s:property value="%{hasRole(\"ROLE_USER\")}"/></s:param>
</s:include>
<br>
<div>
<s:include value="../post/posts.jsp">
  <s:param name="listType">
    <s:property value="'USER'"/>
  </s:param>
  <s:param name="idUser">
    <s:property value="%{user.getId()}"/>
  </s:param>
</s:include>
</div>
<footer style="position: relative; bottom:0;">
  <h6>Made with &#10084;</h6>
</footer>
</body>
</html>

