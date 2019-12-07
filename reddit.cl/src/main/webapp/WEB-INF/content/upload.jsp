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
    <title>Register</title>
    <s:include value="language_pack.js"/>
</head>
<body>
<jsp:include page="user/styles/styleHead.jsp" />
<%--<span onclick="document.getElementById('register').style.display='none'" class="close" title="Close Modal">&times;</span>--%>
<form class="modal-content" action="/action_page.php" method="post">
    <div class="container">
        <h1>Upload</h1>
        <br>
        <label><b>Name</b></label>
        <input type="text" name="nametag" size="20" />
        <label><b>Category</b></label>
        <input type="text" name="nametag" size="50" />

        Select file : <input type='file' name='file' id='file' class='form-control' ><br>

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
