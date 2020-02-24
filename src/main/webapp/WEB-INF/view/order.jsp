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
<%@ include file="/WEB-INF/view/components/header.jsp" %>
<div class="container-fluid">
    <div class="row">

        <div class="col-sm-12  content">
                <div class="row">
                    <div class="col-sm-4"><img src="${car.imagePath}" width="222" height="192"/></div>
                    <div class="col-sm-4">
                        <h3><a href="/show-car?id=${car.id}" style="color: #b6b8b6">${car.brand} ${car.model}</a></h3>
                        <h6>Typ: ${car.carType}</h6>
                        <h6>Przebieg: ${car.mileage}</h6>
                        <h6>Moc [KM]: ${car.enginePower}</h6>

                    </div>
                   <fmt:setLocale value="pl_PL"/>
                    <div class="col-sm-3">Cost <fmt:formatNumber type="currency" minFractionDigits="2">
                       ${car.price}</fmt:formatNumber>
                        <form action="/add-order" method="post" modelAttribute="carEntity" modelAttribute="orderFormDto">


                            <c:if test="${errorStartDate}">
                                <p style="color: red">Pick up day must be later or equal from today</p>
                            </c:if>
                            <label for="dateOfStartRentCar;">Rent Date:</label>
                            <input type="date" id="dateOfStartRentCar;" name="dateOfStartRentCar"><br>
                            <c:if test="${errorDate}">
                                <p style="color: red">Fields can not be empty. invalid date, pick up must be earlier than drop-off car</p>
                            </c:if>
                            <label for="dateOfFinishRentCar">Return date:</label>
                            <input type="date" id="dateOfFinishRentCar" name="dateOfFinishRentCar"><br>
                            <label for="description">Additional information:</label>
                            <input type="text" id="description" name="additionalInformation"><br>

                            <button type="submit" class="btn btn-primary"name="id" value="${car.id}">Rent</button>
                        </form>
                    </div>
                </div>
        </div>
    </div>
</div>



<form action="/add-order" method="POST" modelAttribute="orderFormDto">
<%--    <label for="dateOfStartRentCar;">Data wypożyczenia:</label>--%>
<%--    <input type="date" id="dateOfStartRentCar;" name="dateOfStartRentCar"><br>--%>
<%--    <label for="dateOfFinishRentCar">Data zwrotu auta:</label>--%>
<%--    <input type="date" id="dateOfFinishRentCar" name="dateOfFinishRentCar"><br>--%>
<%--    <label for="description">Dodadkowe informację:</label>--%>
<%--    <input type="text" id="description" name="additionalInformation"><br>--%>
<%--    <button type="submit" class="btn btn-primary">Dodaj zamówienie</button>--%>
</form>


<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>