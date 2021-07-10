<%-- 
    Document   : view
    Created on : May 23, 2021, 9:32:35 AM
    Author     : congfptu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <link rel="stylesheet" type="text/css" href="./template/css/common.css" />
        <link rel="stylesheet" type="text/css" href="./template/css/aside.css" />
        <link rel="stylesheet" type="text/css" href="./template/css/error.css" />
    </head>
    <body>
        <div>
            <div class="">
                <%@include file="/common/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="container flex">
                        <div class="news">
                            <c:choose>
                            <c:when test="${error03 ne null}">
                                  <!--id of news wrong format-->
                                <p class="error-notification">${error03}</p>
                            </c:when>  
                            <c:when test="${error04 ne null}">
                                  <!--id of news not exist-->
                                <p class="error-notification">${error04}</p>
                            </c:when>  
                            <c:otherwise>
                                  <!--Information of news-->
                                <p class="title">${currentNews.title}</p>
                            ${currentNews.content}
                            <hr/>
                            <div class="writer-date">
                                <img class="comment"> 
                                <img class="time-icon"> 
                                By ${currentNews.writer} | ${currentNews.date}
                            </div>
                            </c:otherwise>
                        </c:choose>
                           <!--aside-->
                        </div>
                        <%@include file="/common/aside.jsp" %>
                    </div>
                </div>
                <!--Footer-->
                <footer class="footer">
                </footer>
            </div>
        </div>
    </body>
</html>
