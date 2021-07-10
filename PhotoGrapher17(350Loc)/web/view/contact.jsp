<%-- 
    Document   : contact
    Created on : Jun 13, 2021, 9:40:43 PM
    Author     : congfptu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="/common/header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="country">
                            <p>Address: ${contact.address}<br>City:<span class="tab-1"></span>${contact.city}<br>Country:  ${contact.country}</p>
                        </div>
                        <div class="infor">
                           <p>Tel:<span class="tab-1"></span>${contact.telephone}<br>Email:<span class="tab-2"></span>${contact.email}</p>
                        
                        </div> 
                        <img class="map">
                        
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

