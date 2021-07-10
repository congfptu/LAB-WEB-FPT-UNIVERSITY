<%-- 
    Document   : home
    Created on : Jun 13, 2021, 9:41:23 PM
    Author     : congfptu
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <script src="./js/paging.js" type="text/javascript"></script>
        <title>My Front Page</title>
    </head>
    <body>
         <%@include file="/common/header.jsp"%>
        <div class="container">   
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="${contact.image_main}" alt="First">
                    </div>
                    <div class="description">
                     ${contact.sumary}
                    </div>
                    <div class="content">
                        <c:choose>
                            <c:when test="${error ne null}">
                                <p class="error-notification">${error}</p>       
                            </c:when>
                            <c:otherwise>
                                  <ul >
                                <c:forEach items="${listGalery}" var="i" >
                                    <li class="top3-gallery">
                                        <div class="image">
                                            <img src="${i.image}">
                                        </div>
                                        <p class="title-gallery">
                                            <a href="gallery?galeryID=${i.ID}">${i.title}</a>
                                        <p>
                                        <p>${i.description}</p>
                                    </li>
                                </c:forEach>
                                      </ul>  
                                        <div id="paging" class="paging">
                        </div>
                        <script>
                            renderPager("paging",${index},${totalPages},${gap});    
                        </script>
                            </c:otherwise>
                        </c:choose>  
                                    
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        ${contact.about}
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="/common/right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="/common/footer.jsp"/>

    </body>
</html>

