<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 17.12.2019
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:property value="category.title"/></title>
</head
<s:iterator value="category.name" var="category.name">
    <a style="height: 10px"><s:property value="#category.name"/> </a>
</s:iterator>>
<body>
<s:include value="../user/styles/styleMain2.jsp" />
<s:include value="../header.jsp">
    <s:param name="hasRole"><s:property value="%{hasRole(\"ROLE_USER\")}"/></s:param>
</s:include>
<div>
    <s:include value="../post/posts.jsp">
        <s:param name="listType">
            <s:property value="'CATEGORY'"/>
        </s:param>
        <s:param name="idCategory">
            <s:property value="category.id"/>
        </s:param>
        <s:param name="idUser">
            <s:property value="category.id"/>
        </s:param>
    </s:include>
</div>
</body>
</html>
