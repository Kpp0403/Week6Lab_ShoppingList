<%-- 
    Document   : shoppingList
    Created on : 25-Feb-2023, 2:37:45 PM
    Author     : Krushang Prajapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>
            Shopping List
        </h1>
        <p>
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        </p>
        <h2>
            List
        </h2>
        <form method="post">
            <table>
                <th>
                    Add item:
                </th>
                <td>
                    <input type="text" name="item">
                </td>
                <td>
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add">
                </td>
            </table>
        </form>
        <form method="post">
            <c:forEach var="item" items="${items}">
                <input type="radio" name="itemlist" value="${item}">
                ${item}<br>
            </c:forEach>
            <br>
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
