<%@ page import="logic.Cart" %><%--
  Created by IntelliJ IDEA.
  User: imposya
  Date: 04.06.2022
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
  <% Cart cart = (Cart) session.getAttribute("cart");  %>

<%= "Наименование: " + cart.getName() + " Количество: " + cart.getQuantity()%>
</body>
</html>
