<%--
  Created by IntelliJ IDEA.
  User: maz
  Date: 01.09.2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new order</title>
</head>
<body>
<!--/*@thymesVar id="order" type="ru.gb.entities.Order"*/-->
<form th:action="@{'/orders/add'}" th:object="${order}" method="post">
    Order id: <input type="text" th:field="*{id}"/>
    <br>
    Order date: <input type="Date" th:field="*{date}"/>
    <br>
    Order cost: <input type="number" th:field="*{cost}"/>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
