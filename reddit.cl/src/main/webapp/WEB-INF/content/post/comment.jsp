<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 05.01.2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:set var="id">${param.idComment}</s:set>
<s:set var="idp">${param.idCommentp}</s:set>
<s:set var="body">${param.body}</s:set>
<s:set var="nick">${param.userNick}</s:set>
<s:set var="idUser">${param.idUser}</s:set>
<html>
<a href="<%=request.getContextPath()%>/user/get-user?user.id=<s:property value="#idUser"/>">
    <i><b><s:property value="#nick"/></b></i></a> <br>
<a style="height: 10px"><s:property value="#body"/> </a>
<br>
<div style="margin-left: 20px">
    <s:iterator value="%{getSubcomments(#id)}" var="sub">
        <s:include value="comment.jsp">
            <s:param name="idComment"><s:property value="#sub.id"/></s:param>
            <s:param name="body"><s:property value="#sub.body"/></s:param>
            <s:param name="userNick"><s:property value="#sub.user.nick"/></s:param>
            <s:param name="idUser"><s:property value="#sub.user.id"/></s:param>
        </s:include>
    </s:iterator>
</div>
</html>
