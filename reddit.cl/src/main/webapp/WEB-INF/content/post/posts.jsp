<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 01.12.2019
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:set var="hasRole">${param.hasRole}</s:set>
<s:set var="listType">${param.listType}</s:set>
<s:set var="idCategory">${param.idCategory}</s:set>
<s:set var="idUser">${param.idUser}</s:set>
<%--<div>--%>
<%--    <h2><s:property value="userId"/> </h2>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <h2><s:property value="%{getAllPosts()}"/> </h2>--%>
<%--</div>&ndash;%&gt;--%>
<div style="padding-left:16px">
    <s:include value="../user/styles/styleMain2.jsp" />
    <div >
        <s:iterator value="%{'CATEGORY'.equals(#listType) && #idCategory > 0 ? getAllPostsFromCategory(#idCategory) : 'USER'.equals(#listType) && #idUser > 0 ? getAllPostsOfUser(#idUser) : getAllPosts()}" var="post" status="stat">
            <div class="main">
                <tr>
                    <td>
                        <h2><a href="<%=request.getContextPath()%>/post/show-details?post.id=<s:property value="id"/>" class="tit"><s:property value="title"/></a></h2>
                        <p><s:property value="body"/></p>
                        <s:iterator value="#post.files" var="file">
                        <img class="postImage" src="<%=request.getContextPath()%><s:property value="#file.path"/> " alt="<s:property value="id"/>" style="max-width: 100%">
                        </s:iterator>
                    </td>
                </tr>
                <br>
<%--                <tr>--%>
<%--                    <td><a>upvote</a></td>--%>
<%--                    <td><a>downvote</a></td>--%>
<%--                </tr>--%>
            </div>
            <br>
            <%--<div class="postPlace">
                <br>
                <br>
            </div>--%>
        </s:iterator>
    </div>
</div>
</body>
</html>
