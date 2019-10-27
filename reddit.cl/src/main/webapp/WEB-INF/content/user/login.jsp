<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 19.10.2019
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
<h1>Please log-in</h1>
  <s:form action="/user/log-in.action">
    <s:textfield name="username" label="Username" placeholder="username"/>
    <s:password name="password" label="Password" placeholder="password"/>
    <s:submit value="Log-in"/>
  </s:form>
</body>
</html>
