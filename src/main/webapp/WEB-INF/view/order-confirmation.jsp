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
<%@ include file="/WEB-INF/components/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <%--            <%@include file="/WEB-INF/component/filter.jsp"%>--%>


        </div>
        <div class="col-md-10 offset-md-2 content">
            <div class="row">
                <div class="col-md-3"><img src="${car.imagePath}" width="222" height="192"/></div>
                <div class="col-md-4">
                    <h3><a href="/show-car?id=${car.id}" style="color: #b6b8b6">${car.brand} ${car.model}</a></h3>
                    <h6>Typ: ${car.carType}</h6>
                    <h6>Przebieg: ${car.millage}</h6>
                    <h6>Moc [KM]: ${car.power}</h6>

                </div>
                <h4>Cost per Day </h4>
                <fmt:setLocale value="pl_PL"/>
                <div class="col-md-3"><fmt:formatNumber type="currency" minFractionDigits="2">
                    ${car.price}</fmt:formatNumber>

                </div>
                <div class="col-md-3">
                    <h4>Order successful</h4>
                    <h2>Total cost: ${cost}</h2>
                    <h2>Your Number of order: ${orderNumber}</h2>

                </div>
            </div>
        </div>
    </div>
</div>






<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>