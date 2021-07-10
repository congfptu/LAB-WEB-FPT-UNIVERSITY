<%-- 
    Document   : gallery
    Created on : Jun 13, 2021, 9:41:57 PM
    Author     : congfptu
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./js/paging.js" type="text/javascript"></script>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="/common/header.jsp"/>
            <div class="main">
                <div class="left">
                     
                    <c:choose> 
                        <c:when test="${error01 ne null}">
                            <p class="error-notification">${error01}</p>
                        </c:when>
                        <c:otherwise>

                            <div class="about">
                                <h3>${galery.name}</h3>
                            </div>
                            <c:choose>
                                <c:when test="${error04 ne null}">
                                    <p class="error-notification">${error04}</p>
                                </c:when>
                                <c:otherwise>
                                    <div class="imageGaler">
                                        <img src="${top1Galery.image_url}" alt="First">
                                    </div>
                                </c:otherwise>
                            </c:choose>
                                <c:choose>
                                    <c:when test="${error03 ne null}">
                                    <p class="error-notification">${error03}</p>
                                    </c:when>
                                    <c:otherwise>
                            <div class="contentGalery">
                                <ul >
                                    <c:forEach items="${listImage}" var="i" varStatus="loop">
                                       <div class="shadow">
                                        <li>
             
                                            <a  href="gallery?index=${index}&galeryID=${galeryID}&imgID=${i.id}"><img  class="image-gallery" src="${i.image_url}"></a>                               
                                        </li>
                                       </div>
                                      
                                    </c:forEach>
                                </ul>                            
                                <div id="paging" class="paging">

                                </div>
                                <script>
                                    renderPagerImage("paging",${index},${galeryID},${imgID},${totalPages},${gap});
                                </script>
                            </div>
                                </c:otherwise>
                                </c:choose>

                        </c:otherwise>
                    </c:choose>

                </div>
                
                <div class="right">
                    <jsp:include page="/common/right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="/common/footer.jsp"/>

    </body>
</html>

