<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marianna Dudzinska
  Date: 2019-11-26
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<s:include value="language_pack.js"/>--%>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <s:include value="user/styles/styleHead.jsp" />
</head>
<body>
<s:set var="hasRole">${param.hasRole}</s:set>
<div class="topnav">
    <a id="namespace"><b>reddit.cl</b> </a>
    <a class="active" href="<%=request.getContextPath()%>"><b>Home</b></a>
    <div class="dropdown">
        <button class="dropbtn">Category
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
        <s:iterator value="%{getAllCategories()}" var="cat">
            <a href="<%=request.getContextPath()%>/category/category?idCategory=<s:property value="#cat.id"/>"><s:property value="#cat.name"/></a>
        </s:iterator>
        </div>
    </div>
<%--    <input type="text" placeholder="Search" name="search">--%>

    <div class="right-navbar">
        <s:if test="#hasRole">
            <button onclick="location.href ='<%=request.getContextPath()%>/log-out.cl'" style="width:auto;">Logout</button>
            <button onclick="location.href ='<%=request.getContextPath()%>/post/upload.cl'" style="width:auto;">Upload</button>
        </s:if>
        <s:else>
            <button onclick="location.href ='<%=request.getContextPath()%>/login.cl'" style="width:auto;">Login</button>
            <button onclick="location.href ='<%=request.getContextPath()%>/register.cl'" style="width:auto">Register</button>
        </s:else>
    </div>
</div>
</body>
</html>
<script>
    function myDropdown() {
        document.getElementById("dropdown-content").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
</script>
