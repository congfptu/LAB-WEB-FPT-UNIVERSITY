<%-- 
    Document   : managequiz
    Created on : Jun 2, 2021, 11:31:07 AM
    Author     : congfptu
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Question"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quiz</title>
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
        <script src="./template/js/manageQuiz.js" type="text/javascript"></script>
        <link href="./template/css/managequiz.css" rel="stylesheet" type="text/css"/>


    </head>

    <body>
        <div class="container">
            <%@include file="/common/header.jsp"%>
            <div class="content main-container">
                <div class="form-item">
                    <h3 class="label">Number of Question:<span class="infor number-question">${requestScope.number}</span></h3> 
                </div>
                <ul class="form-item flex">
                    <li><h3 class="infor">Question</h3></li>              
                    <li><h3 class="infor date-created">Date Created</h3></li>
                </ul>
                <c:choose>
                    <c:when test="${mess ne null}">
                        <h5 class="mess">${mess}</h5>  
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${requestScope.questions}" var="q">
                            <ul class="form-item flex">     
                                <li class="left">
                                    <h3 class="label">${q.getContent()}</h3>
                                </li> 
                                <li class="right">
                                    <h3 class="label">${q.getCreatedString()}</h3>
                                    <a id="delete" class="delete" href="delete?qid=${q.getId()}" onclick=" return ask()">Delete</a> 
                                </li>  
                            </ul>
                        </c:forEach>
                    </div>
                    <div class="page_index" id="paging"></div>
                    <c:if test="${totalPage ne 0}">
                        <script>
                                renderPager("paging",${pageIndex},${totalPage}, 2);
                        </script>
                    </c:if>

                </c:otherwise>
            </c:choose>


        </div>

    </div>
</body>

</html>
