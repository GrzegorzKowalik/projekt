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
<head>
    <title><s:property value="post.title"/></title>
</head>
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
        <s:iterator value="post.files" var="file">
            <img class="center" src="<%=request.getContextPath()%><s:property value="#file.path"/> " alt="<s:property value="id"/>" style="max-width: 100%">
        <br>
        </s:iterator>
        <br>
        <h3>Comments</h3>
        <s:iterator value="post.comments" var="comment">
            <a href="<%=request.getContextPath()%>user/get-user?user.id=<s:property value="#comment.user.id"/>">
                <i><s:property value="#comment.user.nick"/></i></a>
            <a><s:property value="#comment.body"/> </a>
            <s:iterator value="#comment.files" var="comFile">
                <img class="center" src="<%=request.getContextPath()%><s:property value="#comFile.path"/> " alt="<s:property value="id"/>" style="max-width: 100%">
            </s:iterator> <br>
            <s:iterator value="#comment.subComments" var="sub">
                <tr><td><a style="margin: 15px;" href="<%=request.getContextPath()%>user/get-user?user.id=<s:property value="#sub.user.id" />"><s:property value="#sub.user.nick"/></a></td></tr>
                <tr><td><a><s:property value="#sub.body"/> </a></td></tr> <br>
                <s:iterator value="#sub.files" var="subFile">
                    <tr><td><img class="center" src="<%=request.getContextPath()%><s:property value="#subFile.path"/> " alt="<s:property value="id"/>" style="max-width: 100%"></td></tr>
                </s:iterator>
            </s:iterator>
        </s:iterator>
        <br>
        <label><b>Add comment</b></label>
        <s:fielderror fieldName="comment.body"/>
        <input type="text" placeholder="Write comment..." name="comment.body" required>
        <button>Post</button>
    </div>
</div>
</body>
</html>
