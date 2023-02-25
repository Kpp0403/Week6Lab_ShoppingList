<%-- 
    Document   : register
    Created on : 25-Feb-2023, 2:34:37 PM
    Author     : Krushang Prajapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>
            Shopping List
        </h1>
        <form action="ShoppingList" method="post">
            <table>
                <tr>
                    <th>
                        Username:
                    </th>
                    <td>
                        <input type="text" name="username" autofocus="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="action" value="register">
                        <input type="submit" value="Register name">
                    </td>
                </tr>
            </table>
        </form>
        <c:if test="${invalid == true}">
            <p>*Please check Username. Enter Correct details.</p>
        </c:if>
    </body>
</html>
