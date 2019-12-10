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
<s:set var="categoryId">${param.categoryId}</s:set>
<s:set var="userId">${param.userId}</s:set>
<%--<div>
    <h2><s:property value="userId"/> </h2>
</div>
<div>
    <h2><s:property value="%{getAllPosts()}"/> </h2>
</div>--%>
<div style="padding-left:16px">
    <%--<s:include value="../user/styles/styleMain.jsp" />--%>
    <div >
        <s:iterator value="%{'CATEGORY'.equals(#listType) && Integer.parseInt(categoryId) > 0 ? getAllPostsFromCategory(#categoryId) : 'USER'.equals(#listType) && Integer.parseInt(userId) > 0 ? getAllPostsOfUser(#userId) : getAllPosts()}" var="post" status="stat">
            <div class="main">
                <tr>
                    <td>
                        <h2><a href="<s:url action="post/show-details"/>?post.id=<s:property value="id"/>" style="text-decoration: none"><s:property value="title"/></a></h2>
                        <p><s:property value="body"/></p>

                            <img class="center" src="<s:if test="#stat.even"><%=request.getContextPath()%>/static/test.jpg</s:if><s:else><%=request.getContextPath()%>/static/test2.jpg</s:else>" alt="<s:property value="id"/>" style="max-width: 600px">

                    </td>
                </tr>
                <br>
                <tr>
                    <td><a>upvote</a></td>
                    <td><a>downvote</a></td>
                </tr>
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
