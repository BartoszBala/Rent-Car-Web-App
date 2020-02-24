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

<a class="btn btn-primary" href="/admin" role="button">Manage orders</a>
<a class="btn btn-primary" href="/manage-cars" role="button">Manage cars</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Client Name</th>
        <th scope="col">Role</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Active</th>
        <th scope="col">Total value of orders</th>
        <th scope="col"></th>
    </tr>
    </thead>

    <tbody>
    <c:set var="counter" value="1"/>
    <c:forEach items="${users}" var="user">
        <tr ${task.completed?'style="background-color: lightgreen"':""}>
            <th scope="row">${user.id}</th>
            <td>  ${user.firstName}  ${user.lastName} </td>
            <td>  ${user.roles}  </td>
            <td>${user.phoneNumber}</td>
            <td>${user.email}</td>
            <td>${user.actived}</td>
            <td>tutaj damy łączną ilość zamówień</td>
            <td>
<%--                    <c:set var="status" value="1"></c:set>--%>
                <c:if test="${user.actived==1&&!user.login.equals('admin')}">
                    <form action="/disactiveUser/${user.id}" method="GET" modelAttribute="orderId">
                        <button style="background: red" class="btn btn-success" name="orderId" value="${order.id}">Disactive user</button>
                    </form>
                </c:if>
    <c:if test="${user.actived==0}">
        <form action="/activeUser/${user.id}" method="GET" modelAttribute="orderId">
            <button class="btn btn-success" name="orderId" value="${order.id}">Active user</button>
        </form>
    </c:if>
            </td>

            <td>
<%--                <c:if test="${!order.orderCompleted}">--%>
<%--                <form action="/cancel" method="POST" modelAttribute="orderId">--%>
<%--                    <button class="btn btn-success" name="orderId" value="${order.id}">Cancel Order</button>--%>
<%--                </form>--%>
<%--                </c:if>--%>


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