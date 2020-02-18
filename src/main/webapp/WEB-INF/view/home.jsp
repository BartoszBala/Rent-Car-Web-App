<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->



</head>
<body>
<%--<%@ include file="/components/header.jsp" %>--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/menagment">Menagment</a></li>
            <li><a href="/admin">Admin</a></li>
            <li><a href="/all">ALL USER</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Rejestracja</a></li>

            <c:if test="${!isAuthenticated}"> <li><a href="/login2"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
            <c:if test="${isAuthenticated}">><li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logut</a></li></c:if>
        </ul>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
<%--            <%@include file="/WEB-INF/component/filter.jsp"%>--%>

            miejsce na filter
        </div>
        <div class="col-md-10 offset-md-2 content">
            <c:forEach items="${cars}" var="car">
                <div class="row">
                    <div class="col-md-3"><img src="${car.imagePath}" width="222" height="192"/></div>
                    <div class="col-md-4">
                        <h3><a href="/show-car?id=${car.id}" style="color: #b6b8b6">${car.brand} ${car.model}</a></h3>
                        <h6>Typ: ${car.carType}</h6>
                        <h6>Przebieg: ${car.millage}</h6>
                        <h6>Moc [KM]: ${car.power}</h6>

                    </div>
                    <fmt:setLocale value="pl_PL"/>
                    <div class="col-md-3"><fmt:formatNumber type="currency" minFractionDigits="2">
                        ${car.price}</fmt:formatNumber>
                        <form action="/prepare-order" method="post" modelAttribute="carEntity">
                            <button type="submit" class="btn btn-primary"name="id" value="${car.id}">Złóż zamówienie</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>



<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>