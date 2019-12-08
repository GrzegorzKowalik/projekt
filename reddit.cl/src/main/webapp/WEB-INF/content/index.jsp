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
  <div id="stylesInclude">
    <s:include value="user/styles/styleMain.jsp" />
    <s:include value="user/styles/styleHead.jsp" />
  </div>
</head>
<body>
<s:include value="header.jsp">
  <s:param name="hasRole"><s:property value="%{hasRole(\"ROLE_USER\")}"/></s:param>
</s:include>

<div style="padding-left:16px">
  <div class="main">
    <h2>TITLE HEADING</h2>
    <h5>Title description, Dec 7, 2017</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text..</p>
    <br>

  </div>

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
<script>
  var M1style = "user/styles/styleMain2.jsp";
  var M2style = "user/styles/styleMain1.jsp";

  var Hstyle = "user/styles/styleHead.jsp";
</script>
</html>

