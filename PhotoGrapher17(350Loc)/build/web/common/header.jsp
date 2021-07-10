<%-- 
    Document   : header
    Created on : Jun 13, 2021, 9:41:02 PM
    Author     : congfptu
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body>
       
        <div class="nav">
        
            <div class= "nav-inner">
                <ul>
                    <li> <a class="${active=="0"?"activeMenu":""}" href="${pageContext.request.contextPath}/home">My front page</a></li>
                        <c:forEach items="${topGalery}" var="i" >
                        <li> <a class="${active==i.ID?"activeMenu":""}" href="gallery?galeryID=${i.ID}">${i.name}</a> </li>
                        </c:forEach>
                          
                    <li> <a class="${active=="1"?"activeMenu":""}" href="${pageContext.request.contextPath}/contact">Contact</a> </li>
                </ul>
            </div>
             

        </div>
        <div class="header">
            <div class="header-inner">
                <img class="img">
                
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
