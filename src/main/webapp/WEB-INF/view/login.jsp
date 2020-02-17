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
<h1>Logowanie użytkownika</h1>

<%--@elvariable id="loginForm" type=""--%>
<form:form method = "POST" action = "/login" modelAttribute="loginForm">
    <%--    <form:errors path = "*" cssClass = "errorblock" element = "div" />--%>
<table>
    <tr>
        <td>
            <form:label path = "login">login</form:label>
        </td>
        <td><form:input path = "login" /></td>
        <td><form:errors cssStyle="color: red" path = "login" cssClass = "error" />
            <c:if test="${invalidLogin}">
                <p style="color: red">Niepoprawne hasło lub email</p>
            </c:if>
        </td>

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
        <td colspan = "2">
            <input type = "submit" value = "zaloguj">
        </td>
    </tr>
</table>
</form:form>


<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>