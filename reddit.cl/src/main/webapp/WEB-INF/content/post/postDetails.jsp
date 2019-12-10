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
<s:include value="../user/styles/styleMain.jsp" />
<s:include value="../header.jsp">
    <s:param name="hasRole"><s:property value="%{hasRole(\"ROLE_USER\")}"/></s:param>
</s:include>
<br>
<div style="padding-left:16px">
    <div class="main">
        <h2><s:property value="post.title"/></h2>
        <h5><s:property value="post.tsCreated"/></h5>
        <p><s:property value="body"/></p>
        <img src="<%=request.getContextPath()%>/static/test.jpg" alt="<s:property value="id"/>" style="width: 100%">
        <br>
        <s:iterator value="post.comments" var="comment">
            <h2><s:property value="#comment.subComments"/></h2>
            <a href="<s:url action="user/get-user"/>?user.id="<s:property value="comment.user.id"/>><s:property value="comment.user.nick"/></a>
        </s:iterator>
    </div>
</div>
</body>
</html>
