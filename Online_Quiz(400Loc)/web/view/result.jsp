<%-- 
    Document   : result
    Created on : Jun 2, 2021, 11:22:23 AM
    Author     : congfptu
--%>

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
            <c:choose> 
                <c:when test="${mark!=Empty}">
                    <div class="content">
                        <div class="infor-container">
                            <h3 class="label">Your score  
                                <span id="mark" class="infor">${mark}</span>
                                <span class="infor" id="percent">(${percent}%)</span> 
                                <span class="infor isPass"> - ${isPass}</span>       
                            </h3>
                        </div>
                        <div class="infor-container">
                            <h3 class="label" >Take another test 
                                <a class="start" href="takequiz">
                                    <button class="button btn-start">Start</button>
                                </a>
                            </h3>

                        </div>
                    </div>       
                </c:when>
                <c:otherwise>
                    <h3 class="mess">${requestScope.mess}</h3>
                </c:otherwise>
            </c:choose> 
        </div>
    </body>
</html> 
