<%-- 
    Document   : take_quiz
    Created on : Jun 2, 2021, 10:12:18 AM
    Author     : congfptu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
        <link href="./template/css/takequiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="/common/header.jsp"%>

            <div class="content">
                <h5 class="label">Welcome </h5> 
                <span class="infor">${user.getUserName()}</span> 
                <div id="timer">
                    <h3 class="label">Time remaining</h3>
                    <span id="time">${labeltime}</span>
                </div>
                <div id="answer-container">                    
                    <c:forEach items="${questions}" var="q">
                        <div class="ques" id="${q.getId()}">
                            <h3 class="ques-title">${q.getContent()}</h3> 
                            <c:set var="answers" value="${q.getAnswers()}"/>
                            <c:forEach items="${answers}" var="a">
                                <input name="${q.getId()}" class="op"
                                       id="${a.getId()}" 
                                       type="checkbox"
                                       value="${a.getId()}"/>
                                <label class="answer-label  text-display" for="${a.getId()}">${a.getContent()}</label>
                                <br> 
                            </c:forEach>                           
                        </div>
                    </c:forEach>   
                    </div>
                    <c:choose>
                        <c:when test="${number eq 1}">
                            <button class="button" id="nextBtn" onclick="nextQuestion()">Finish</button>
                        </c:when>
                        <c:otherwise>
                            <button class="button" onclick="nextQuestion()" id="nextBtn">Next</button>
                        </c:otherwise>
                    </c:choose>
                
            </div>
            <form id="result-form" type="hidden" method="post" action="takequiz">
                <input id="result" name="result" type="hidden"/> 
            </form>  
        </div>
        <script src="./template/js/takeQuiz.js" type="text/javascript"></script>
    </body>
</html>

