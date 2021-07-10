<%-- 
    Document   : aside.jsp
    Created on : May 12, 2021, 9:28:34 AM
    Author     : congfptu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./template/css/aside.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" type="text/css" href="./template/css/error.css" />
        <script src="./template/js/javascript.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
 
    <body>
        <div class="aside">
            <!--The most recent news-->
            <div>
                <p class="title ">Digital News</p>
                <p class="content-news">${mostRecentNews.description}</p>
            </div>
            <!--Search news by new title-->
            <div>
                <p class="title">Search</p>
                <form class="flex" method="GET" id="form-search" action="search" onsubmit=" return empty()"  >
                    <input type="text" class="search" id="text-search" required="" name="keyword" >
                    <input type="submit" class="search-btn " value="Go" onsubmit="empty()">     
                </form>
                   <span id="bug" class="error-notification empty-keyword"></span>   
            </div>
            <!--Top 5 most recent news-->
                <p class="title top-articles">Last Articles</p>
                <ul class="list-articles">
                    <c:forEach var="news" items="${listRecentNews}">
                        <li class="list-news-item">
                            <a href="view?id=${news.id}">${news.title}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>
</html>
