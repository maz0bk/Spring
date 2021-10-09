<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 01.09.2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new order</title>
</head>
<body>
<%--<h1>${testString}</h1>--%>
<c:url var="add_order_url" value="/order"/>
<form:form action="${add_order_url}" modelAttribute="order" method="post">
    <form:label path="id">Order id: </form:label> <form:input type="text" path="id"/>
    <br>
    <form:label path="date">Order date: </form:label> <form:input type="Date" path="date"/>
    <br>
    <form:label path="cost">Order cost: </form:label> <form:input type="number" path="cost"/>
    <br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
