<%-- 
    Document   : shoppingList
    Created on : 26-Feb-2023, 1:40:50 PM
    Author     : darkn
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1><b>Shopping List</b></h1>
        <p> Hello, ${username} 
            <a href="ShoppingList?action=logout"> Logout </a>
        </p>
        <h2>List</h2>
        <form action="" method="POST">
            Add item: <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        
        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${items}">
                    <li> 
                        <input type="radio" name="${item}" value="${item}">${item}
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
