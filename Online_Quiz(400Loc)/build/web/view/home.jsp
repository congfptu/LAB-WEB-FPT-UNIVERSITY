<%-- 
    Document   : home
    Created on : May 31, 2021, 10:56:47 AM
    Author     : congfptu
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Home</title>
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="/common/header.jsp"%>
            <div class="content">
                <h3 class="label">Welcome </h3> 
                <span class="infor">${sessionScope.user.getUserName()}</span> 
                <div class="mess mess-error">
                    <c:if test="${mess!=Empty}">
                        <h5>${mess}</h5>  
                    </c:if> 
                </div> 
            </div> 
        </div>
    </body>
</html>
