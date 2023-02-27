<%-- 
    Document   : register
    Created on : 27-Feb-2023, 2:40:32 AM
    Author     : darkn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1><b>Shopping List</b></h1>
        <form action ="ShoppingList" method="POST">
            Username: <input type="text" name="username"> 
            <input type="hidden" name="action" value="register">
            <input type ="submit" value="Register name">
        </form>
    </body>
</html>
