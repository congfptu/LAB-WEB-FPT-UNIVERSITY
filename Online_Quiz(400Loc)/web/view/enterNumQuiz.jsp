

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
            <c:set var="user" scope="session" value="${sessionScope.user}"/>
            <c:set var="mess" scope="request" value="${requestScope.mess}"/>
            <%@include file="/common/header.jsp"%>
            <div class="content">
                <h3 class="label">Welcome </h3> 
                <span class="infor">${sessionScope.user.getUserName()}</span> 
                <h3 id="number-ques" class="label">Enter number of Questions:</h3><br>
                <form id="number-form" class="form" method="get" action="takequiz">
                    <div class="form-item">
                        <input  type="text" id="number-input" name="number"/>
                    </div>
                    <div class="form-item form-button">
                        <input class="" id="number-button" type="submit" value="Start"/>
                    </div>                        
                </form>
                <c:if test="${mess ne null}">
                    <h5 class="mess">${mess}</h5>  
                </c:if>   
            </div>
        </div> 
    </body>
</html>
