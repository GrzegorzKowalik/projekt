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
<s:include value="../user/styles/styleMain2.jsp" />
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
            <img class="postImage" src="<%=request.getContextPath()%><s:property value="#file.path"/> " alt="<s:property value="id"/>" style="max-width: 100%">
            <br>
        </s:iterator>
        <br>
        <h3>Comments</h3>
        <s:iterator value="post.comments" var="comment">
            <s:include value="comment.jsp">
                <s:param name="idComment"><s:property value="#comment.id"/></s:param>
                <s:param name="body"><s:property value="#comment.body"/></s:param>
                <s:param name="userNick"><s:property value="#comment.user.nick"/></s:param>
                <s:param name="idUser"><s:property value="#comment.user.id"/></s:param>
            </s:include>
        </s:iterator>
        <br>
        <s:if test="%{hasRole(\"ROLE_USER\")}">
            <label><b>Add comment</b></label>
            <form action='<%=request.getContextPath()%>/post/add-comment.cl' method="post">
                <s:hidden name="postId" value="%{post.id}"/>
                <s:fielderror fieldName="comment.body"/>
                <input type="text" placeholder="Write comment..." name="comment.body" required>
                <button type="submit">Add comment</button>
            </form>
        </s:if>
    </div>
</div>
</body>
</html>

<script>
    function postComment() {
        /*var newComments = [];
        newComments.push({body: "${comment.body}", nick: "${comment.user.nick}"});*/
        console.log("chuj");
    }
</script>
