<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 07.09.2021
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<c:url var="del_product_url" value="/delProduct"/>
<form:form action="${del_product_url}" modelAttribute="product" method="post">
    <form:label path="id">product id: </form:label> <form:input type="number" path="id"/>
    <input type="submit" value="Delete"/>
</form:form>
</body>
</html>
