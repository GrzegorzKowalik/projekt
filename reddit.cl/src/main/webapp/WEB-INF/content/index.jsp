<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: uranm
  Date: 19.10.2019
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>REDDIT.CL</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <s:include value="user/styles/styleMain2.jsp" />
   <%-- <s:include value="user/styles/styleHead.jsp" />--%>
</head>
<body>
<s:include value="header.jsp">
  <s:param name="hasRole"><s:property value="%{hasRole(\"ROLE_USER\")}"/></s:param>
</s:include>
<br>
<div>
<s:include value="post/posts.jsp">
  <s:param name="listType">
    <s:property value="'ALL'"/>
  </s:param>
</s:include>
</div>

<%--<script>
  // Get the modal
  var modal = document.getElementById('register');
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

  var modal = document.getElementById('login');
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
</script>--%>
<footer style="position: relative; bottom:0;">
  <h6>Made with &#10084;</h6>
</footer>
</body>
</html>

