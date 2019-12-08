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
  <title>Admin panel</title>
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
    <h3>Change the style</h3>
    <button onclick="onClickBright()"><b>Bright mode</b></button>
    <button onclick="onClickDark()"><b>Dark mode</b></button>
    <br>

  </div>

</div>
<script>
  function onClickDark() {
    console.log("dark");
    var bright = "styleMain.jsp";
    var dark = "styleMain2.jsp";
    var str = document.getElementById("stylesInclude").innerHTML;
    var res = str.replace(bright, dark);
    console.log(str);
   // location.reload();
  }
  function onClickBright() {
    console.log("bright");
    var bright = "styleMain.jsp";
    var dark = "styleMain2.jsp";

    var Dtheme = "background-color: #171A1C;";
    var Btheme = "background-color: #dddddd;";
    var str = document.getElementById("stylesInclude").innerHTML;
    var res = str.replace(Dtheme, Btheme);
    //console.log(str);
   location.reload();
  }
</script>
<footer style="position: relative; bottom:0;">
  <h6>Made with &#10084;</h6>
</footer>
</body>
</html>

