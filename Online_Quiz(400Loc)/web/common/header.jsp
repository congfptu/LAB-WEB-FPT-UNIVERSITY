<%-- 
    Document   : header
    Created on : May 31, 2021, 10:56:01 AM
    Author     : congfptu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./template/css/header.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <body>
        <header class="header-container">
            <ul class="header">
                <li><a class="header-item" href="home">Home</a></li>
                <li><a class="header-item" href="takequiz">Take Quiz</a></li>
                <li><a class="header-item" href="makequiz">Make Quiz</a></li>
                <li><a class="header-item" href="managequiz">Manage Quiz</a></li>
                    <c:if test="${user!=Empty}">
                    <li><a class="header-item" href="LogOutController">Log out</a></li>
                    </c:if>
            </ul>
        </header>
    </body>
</html>