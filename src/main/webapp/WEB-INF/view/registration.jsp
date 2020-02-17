<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Rejestrowanie użytkownika</h1>


<%--@elvariable id="registrationForm" type=""--%>
<form:form method = "POST" action = "/register" modelAttribute="registrationForm">
<%--    <form:errors path = "*" cssClass = "errorblock" element = "div" />--%>
    <table>
        <tr>
            <td>
                <form:label path = "login">login</form:label>
            </td>
            <td><form:input path = "login" /></td>
            <td><form:errors cssStyle="color: red" path = "login" cssClass = "error" /></td>

        </tr>
        <tr>
            <td>
                <form:label path = "password">hasło</form:label>
            </td>
            <td>
                <form:password path = "password" />
            </td>
            <td><form:errors cssStyle="color: red" path = "password" cssClass = "error" /></td>
        </tr>
        <tr>
            <td>
                <form:label path = "email">email</form:label>
            </td>
            <td>
                <form:input path = "email" />
            </td>
            <td><form:errors cssStyle="color: red" path = "email" cssClass = "error" /></td>
        </tr>
        <tr>
            <td>
                <form:label path = "phoneNumber">telefon</form:label>
            </td>
            <td>
                <form:input path = "phoneNumber" />
            </td>
            <td><form:errors cssStyle="color: red" path = "phoneNumber" cssClass = "error" /></td>
        </tr>
        <tr>
            <td>
                <form:label path = "firstName">imię</form:label>
            </td>
            <td>
                <form:input path = "firstName" />
            </td>
            <td><form:errors cssStyle="color: red" path = "firstName" cssClass = "error" /></td>
        </tr>
        <tr>
            <td>
                <form:label path = "lastName">nazwisko</form:label>
            </td>
            <td>
                <form:input path = "lastName" />
            </td>
            <td><form:errors cssStyle="color: red" path = "lastName" cssClass = "error" /></td>
        </tr>
        <tr>
        <td>
            <form:label path = "street">ulica</form:label>
        </td>
        <td>
            <form:input path = "street" />
        </td>
            <td><form:errors cssStyle="color: red" path = "street" cssClass = "error" /></td>
    </tr>
        <tr>
            <td>
                <form:label path = "city">miasto</form:label>
            </td>
            <td>
                <form:input path = "city" />
            </td>
            <td><form:errors cssStyle="color: red" path = "city" cssClass = "error" /></td>
        </tr>
        <tr>
            <td>
                <form:label path = "postCode">kod pocztowy</form:label>
            </td>
            <td>
                <form:input path = "postCode" />
            </td>
            <td><form:errors cssStyle="color: red" path = "postCode" cssClass = "error" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "zarejestruj">
            </td>
        </tr>


    </table>
</form:form>


<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>