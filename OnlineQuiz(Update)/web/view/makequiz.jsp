<%-- 
    Document   : makequiz
    Created on : Jun 6, 2021, 3:51:52 PM
    Author     : congfptu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz</title>
        <link href="./template/css/makequiz.css" rel="stylesheet" type="text/css"/>
        <link href="./template/css/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="/common/header.jsp"%>
            <div class="mess">
                <center>
              <c:if test="${errorEmpty ne null}">
            
                    <h5 id="mess">${errorEmpty}</h5>   
            </c:if>
                    </center>
              </div>
            <div class="content">
                <form id="make-form" class="form" method="POST" action="makequiz">
                    <div class="form-item">
                        <label for="question" class="label">Question: </label>
                        <textarea id="question" name="question">${param.question}</textarea>
                    </div>   
                    <div class="form-item">
                        <label for="option1" class="label">Option1: </label>   
                        <textarea id="option1" name="option1">${param.option1}</textarea>
                    </div>
                    <div class="form-item">
                        <label for="option2" class="label">Option2: </label>     
                        <textarea id="option2" name="option2">${param.option2}</textarea>
                    </div>
                    <div class="form-item">
                        <label for="option3" class="label">Option3: </label>
                        <textarea id="option3" name="option3">${param.option3}</textarea>
                    </div>
                    <div class="form-item">
                        <label for="option4" class="label">Option4: </label> 
                        <textarea id="option4" name="option4">${param.option4}</textarea>
                    </div>

                    <div class="form-item">  
                        <label class="label">Answer(s):</label> 
                        <div class="option-container">
                            <div class="option-item">
                                <input class="option-answer" ${param.op1?"checked=\"checked\"":""} name="op1" id="op1" type="checkbox" value="true"/>
                                <label class="label op-label" for="op1">Option 1 </label>
                            </div>
                            <div class="option-item">
                                <input class="option-answer"  ${param.op2?"checked=\"checked\"":""} name="op2" id="op2" type="checkbox" value="true"/>
                                <label class="label op-label" for="op2">Option 2</label>
                            </div>
                            <div class="option-item">
                                <input class="option-answer" ${param.op3?"checked=\"checked\"":""} name="op3" id="op3" type="checkbox" value="true"/> 
                                <label class="label op-label" for="op3">Option 3</label>
                            </div>
                            <div class="option-item">
                                <input class="option-answer"  ${param.op4?"checked=\"checked\"":""} name="op4" id="op4" type="checkbox" value="true"/> 
                                <label class="label op-label" for="op4">Option 4</label>       
                            </div>
                        </div>
                    </div>                      
                    <div class="mess">
                        <input id="btn-save" class="button save-btn" type="submit" value="Save"/> 
                        <h5 id="mess">${mess}</h5>  
                    </div>                   
                </form>
            </div>
        </div>
        
    </body>
</html>