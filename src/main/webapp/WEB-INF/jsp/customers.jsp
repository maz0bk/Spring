<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 10.09.2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <c:forEach var="customer" items="${customers}">
        <li><h3>Customer: ${customer.name}</h3></li>
        <br>
        <span>Product list:</span>
        <br>
        <c:forEach var="product" items="${customer.productList}">
            <span>${product.name}</span>
            <span>${product.price}</span>
            <br>
        </c:forEach>
        <br>
    </c:forEach>
</ul>
</body>
</html>
