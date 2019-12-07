<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 26.11.2019
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div style="padding-left:16px">
    <div class="main">
        <h2><s:property value="post.title"></h2>
        <h5><s:property value="post.ts_created"/></h5>
        <div class="fakeimg" style="height:200px;"></div>
        <p><s:property value="post.body"></p>
        <br>
    </div>
</div>
</body>
</html>
