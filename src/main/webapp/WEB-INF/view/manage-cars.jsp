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

<a class="btn btn-primary" href="/admin" role="button">Manage orders</a>
<a class="btn btn-primary" href="/manage-users" role="button">Manage users</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Car Id</th>
        <th scope="col">VIN</th>
        <th scope="col">Brand</th>
        <th scope="col">Model</th>
        <th scope="col">Millage</th>
        <th scope="col">Type</th>
        <th scope="col">Colour</th>
        <th scope="col"></th>
    </tr>
    </thead>

    <tbody>
    <c:set var="counter" value="1"/>
    <c:forEach items="${cars}" var="car">
        <tr ${task.completed?'style="background-color: lightgreen"':""}>
            <th scope="row">${car.id}</th>
            <td>  ${car.vin} </td>
            <td>  ${car.brand}  </td>
            <td>${car.model}</td>
            <td>${car.millage}</td>
            <td>${car.carType}</td>
            <td>${car.carColour}</td>

        </tr>
        <c:set var="counter" value="${counter+1}"/>
    </c:forEach>

    </tbody>
</table>

<a href="/addcar">
    <button>Add car</button>
</a>




<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>