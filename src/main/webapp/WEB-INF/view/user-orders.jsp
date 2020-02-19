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

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">No.</th>
        <th scope="col">Date of Order</th>
        <th scope="col">pick up Day</th>
        <th scope="col">drop off Day</th>
        <th scope="col">Car</th>
        <th scope="col">Total Cost</th>
    </tr>
    </thead>

    <tbody>
    <c:set var="counter" value="1"/>
    <c:forEach items="${userOrders}" var="order">
        <tr ${task.completed?'style="background-color: lightgreen"':""}>
            <th scope="row">${counter}</th>
            <td>  ${order.dateOfOrder}  </td>
            <td>${order.dateOfStartRentCar}</td>
            <td>${order.dateOfFinishRentCar}</td>
            <td>${order.carEntity.brand} ${order.carEntity.model}</td>
            <td>${order.orderCost}</td>
            <td>

                <c:if test="${!task.completed}">
                    <form action="/demo/mark-as-done" method="POST">
                        <button class="btn btn-success" name="taskId" value="${task.id}">Completed</button>
                    </form>
                </c:if>
            </td>

            <td>
                <form action="/delete" method="POST">
                    <button class="btn btn-success" name="taskId" value="${task.id}">Remove</button>
                </form>
            </td>


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