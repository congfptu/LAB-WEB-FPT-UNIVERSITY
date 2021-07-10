<%-- 
    Document   : login
    Created on : May 31, 2021, 10:58:15 AM
    Author     : congfptu
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <%@include file="/common/header.jsp"%>
            <div class="content">
                <h1 id="form-title">Login Form</h1>  
                <div class="mess">
                    <c:if test="${mess!=Empty}">
                        <h5>${mess}</h5>  
                    </c:if> 
                </div>                  
                <form class="form" method="post" action="home">
                        <label class="title" for="username">User name:</label> 
                        <input type="text" required name="username" class="item-form" value="${param.username}"/>
                        <br>
                        <label class="title" for="password">Password:</label> 
                        <input type="password" required id="password" name="password" value="${param.password}"/>
                        <br>
                        <input type="submit" id="login-btn" class="button-login" value="Sign in"/>
                        <a href="register" id="register" class="title">Register</a>
                </form>
            </div> 
        </div>
    </body>
</html>