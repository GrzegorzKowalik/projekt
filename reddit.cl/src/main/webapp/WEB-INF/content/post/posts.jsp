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
<div>
    <s:iterator value="paginatedPosts">
        <tr>
            <td>
                <h2><s:property value="title"/></h2>
                <p><s:property value="body"/></p>
                <div class="fakeimg" style="height:200px;">Image</div>
            </td>
        </tr>
    </s:iterator>
</div>
</body>
</html>
