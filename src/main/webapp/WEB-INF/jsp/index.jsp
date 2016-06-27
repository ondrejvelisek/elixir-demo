<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="${pageContext.request.locale}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>

    <title>Beacon test service</title>
</head>
<body>

    <nav class="header navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img src="<c:url value="/resources/img/logo.png"/>" alt="logo"/> Beacon test service
                </a>
            </div>
        </div>
    </nav>


    <div class="content container">
        <div class="row">
            <div class="col-sm-12">

                <dl class="dl-horizontal lead">
                    <dt>Sub</dt>
                    <dd>${userinfo.sub}</dd>
                    <dt>Name</dt>
                    <dd>${userinfo.name}</dd>
                    <dt>Email</dt>
                    <dd>${userinfo.email}</dd>
                    <dt>Bona fide</dt>
                    <dd>${userinfo.bona_fide_status}</dd>
                </dl>

            </div>
        </div>
    </div>

    <nav class="footer navbar navbar-default">
        <div class="container">
            <p class="navbar-text">Ondrej Velisek</p>
        </div>
    </nav>

</body>
</html>
