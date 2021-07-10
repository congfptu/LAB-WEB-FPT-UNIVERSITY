<%-- 
    Document   : register
    Created on : Jun 7, 2021, 12:19:39 AM
    Author     : congfptu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <c:set var="mess" scope="session" value="${sessionScope.mess}"/>
            <%@include file="/common/header.jsp"%> 
            <div class="content">
                <h1 id="form-title">Registration Form</h1>
                <div class="mess">
                    <c:if test="${mess!=Empty}">
                        <h5>${mess}</h5>  
                    </c:if> 
                </div> 
                <form class="form" method="post" action="register">
                    <div class="form-item">
                        <label class="label" for="userName">User name:</label> 
                        <input type="text"  id="userName" name="userName" value="${param.userName}"/>
                    </div>
                    <div class="form-item">
                        <label class="label" for="password">Password:</label> 
                        <input type="password" id="password" name="password" value="${param.password}"/>
                    </div>
                    <div class="form-item">
                        <label class="label" for="type">User Type:</label> 
                        <select id="type" name="userType">
                            <c:choose>
                                <c:when test="${fn:contains(param.userType, 'false')}">
                                    <option value="true">Teacher </option>
                                    <option value="false" selected>Student</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="true" selected>Teacher </option>
                                    <option value="false">Student</option>
                                </c:otherwise>
                            </c:choose>                          
                        </select>
                    </div>
                    <div class="form-item">
                        <label class="label" for="email">Email:</label> 
                        <input type="text" id="email" name="email" value="${param.email}"/>
                    </div>
                    <div class="form-item form-button">
                        <input type="submit" id="register-btn" value="Register"/> 
                    </div>                   
                </form>  
            </div>

        </div>
    </body>
</html>
