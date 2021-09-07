<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 07.09.2021
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product info</title>
</head>
<body>
<h1>Product info:</h1>
<span>  ID: ${product.id}</span>
<br>
<span> Name: ${product.name}</span>
<br>
<span> Price: ${product.price}</span>
</body>
</html>
