<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 03.11.2019
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<jsp:include page="../user/styles/styleMain2.jsp" />
<%--<span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>--%>
<form class="modal-content" action="<%=request.getContextPath()%>/post/add-post.cl" method="post" enctype="multipart/form-data">
    <div class="container">
        <h1>Upload</h1>
        <br>
        <label><b>Title</b></label>
        <input type="text" name="postDTO.title" size="10" placeholder="Enter title..." required/>
        <label><b>Category</b></label>
        <select name="postDTO.idCategory" required>
            <s:iterator value="%{getAllCategories()}" var="cat">
                <option value="<s:property value="#cat.id"/>"><s:property value="#cat.name"/></option>
            </s:iterator>
        </select>
        <br>
        <br>
        <label><b>Body</b></label>
        <br>
        <textarea name="postDTO.body" rows="10" cols="30" placeholder="Enter description..."></textarea>
        <br>
        Select file : <input type='file' multiple="multiple" name='files' id='files' class='form-control' ><br>
        <div class="clearfix">
            <%--<button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>--%>
            <button type="submit" class="loginbtn">Upload</button>
        </div>
    </div>
</form>
<%--<h1>Fill the registration form</h1>
<s:form action="sign-in.action">
    <s:textfield name="userDTO.nick" label="Nickname" placeholder="nickname"/>
    <s:textfield name="userDTO.email" label="Email" placeholder="email"/>
    <s:password name="userDTO.password" label="Password" placeholder="password"/>
    <s:submit value="Sign-in"/>
</s:form>--%>
</body>
</html>
