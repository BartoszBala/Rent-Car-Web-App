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

<a class="btn btn-primary" href="/manage-users" role="button">Manage users</a>
<a class="btn btn-primary" href="/manage-cars" role="button">Manage cars</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Client Name</th>
        <th scope="col">Date of Order</th>
        <th scope="col">Return Day</th>
        <th scope="col">Car</th>
        <th scope="col">Information From Client</th>
        <th scope="col">Cost</th>
    </tr>
    </thead>

    <tbody>
    <c:set var="counter" value="1"/>
    <c:forEach items="${orders}" var="order">
        <tr ${task.completed?'style="background-color: lightgreen"':""}>
            <th scope="row">${order.id}</th>
            <td>  ${order.userEntity.firstName}  ${order.userEntity.lastName} </td>
            <td>${order.dateOfStartRentCar}</td>
            <td>${order.dateOfFinishRentCar}</td>
            <td>${order.carEntity.brand}</td>
            <td>${order.additionalInformation}</td>
            <td>${order.orderCost}</td>
            <td>

                <c:if test="${!order.orderCompleted}">
                    <form action="/updateOrder" method="POST" modelAttribute="orderId">
                        <button class="btn btn-success" name="orderId" value="${order.id}">Change order</button>
                    </form>
                </c:if>
            </td>

            <td>
                <c:if test="${!order.orderCompleted}">
                <form action="/cancel" method="POST" modelAttribute="orderId">
                    <button class="btn btn-success" name="orderId" value="${order.id}">Cancel Order</button>
                </form>
                </c:if>


        </tr>
        <c:set var="counter" value="${counter+1}"/>
    </c:forEach>

    </tbody>
</table>



<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>