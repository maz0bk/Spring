<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 07.09.2021
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new product</title>
</head>
<body>
<%--<h1>${testString}</h1>--%>
<c:url var="add_product_url" value="/newProduct"/>
<form:form action="${add_product_url}" modelAttribute="product" method="post">
    <form:label path="name">product name: </form:label> <form:input type="String" path="name"/>
    <br>
    <form:label path="price">product price: </form:label> <form:input type="number" path="price"/>
    <br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
