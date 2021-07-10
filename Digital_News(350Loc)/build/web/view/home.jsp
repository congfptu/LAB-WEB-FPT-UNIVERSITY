<%-- 
    Document   : home.jsp
    Created on : May 9, 2021, 9:21:10 AM
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
        
    </head>
    <body>
        <div>
            <div>
                <%@include file="/common/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="container flex">
                        <div class="news">
                            <p class="title">${mostRecentNews.title}</p>
                            ${mostRecentNews.content}
                            <hr/>
                            <div class="writer-date">
                                <img class="comment" > 
                                <img class="time-icon"> 
                                By ${mostRecentNews.writer} | ${mostRecentNews.date}
                            </div>
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
