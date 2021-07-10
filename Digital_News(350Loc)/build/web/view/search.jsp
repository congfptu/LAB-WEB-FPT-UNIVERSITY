<%-- 
    Document   : search.jsp
    Created on : May 12, 2021, 9:22:35 AM
    Author     : congfptu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="./template/css/common.css" />
        <link rel="stylesheet" type="text/css" href="./template/css/search.css" />
        <link rel="stylesheet" type="text/css" href="./template/css/error.css" />
        <script src="./template/js/javascript.js" type="text/javascript"></script>


    </head>
    <body>
        <div>
            <div class="font-sans text-blue">
                <%@include file="/common/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="container flex">
                        <div class="news">
                            <c:choose>

                                <c:when test="${error01 ne null}">
                                    <!--Current Page not found-->
                                    <p class="error-notification">${error01}</p>
                                </c:when>  

                                <c:when test="${pageError ne null}">
                                    <!--Wrong format Current Page-->
                                    <p class="error-notification">${pageError}</p>
                                </c:when> 

                                <c:when test="${empty listResults}">  
                                    <!--Do not have any news contains keyword-->
                                    <p class="not-found">Not found any news contain keyword "${keyword}"</p>
                                </c:when>  
                                <c:otherwise>
                                    <!--List of articles find by keyword-->
                                    <c:forEach var="news" items="${listResults}">
                                        <a class="news-search" href="view?id=${news.id}">
                                            <p class="title aside-banner-text">${news.title}</p>
                                            <div class="news-keyword">
                                                ${news.images}
                                                <p class="content-news">${news.description}</p>
                                            </div>  
                                        </a>
                                        <hr/>
                                    </c:forEach>
                                    <!--Paging-->
                                    <div class="page_index" id="paging">
                                    </div>
                                    <c:if test="${totalPages ne 0}">
                                        <script>
                                            renderPager("paging",${currentPage},${totalPages}, 2, "${keyword}");
                                        </script>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
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