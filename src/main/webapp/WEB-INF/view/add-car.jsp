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
<%@ include file="/WEB-INF/view/components/header.jsp" %>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 sidebar">
            <%--            <%@include file="/WEB-INF/component/filter.jsp"%>--%>

            <%--            miejsce na filter--%>
        </div>
        <div class="col-md-4 offset-md-4 content">
            <h1>Add Car</h1>
            <%--@elvariable id="carDto" type=""--%>
            <form:form method = "POST" action = "/addCar" modelAttribute="carDto">
                <%--    <form:errors path = "*" cssClass = "errorblock" element = "div" />--%>
                <table>
                    <tr>
                        <td>
                            <form:label path = "vin">VIN</form:label>
                        </td>
                        <td><form:input path = "vin" /></td>
                        <td><form:errors cssStyle="color: red" path = "vin" cssClass = "error" />
                        </td>

                    </tr>


              <tr>
                  <td>                <form:label path = "brand">BRAND</form:label></td>

    <td><form:select  path="brand">
        <form:options cssStyle=" width: 150px" items="${brands}"></form:options>
    </form:select>
    </td>

              </tr>

                    <tr>
                        <td>
                            <form:label path = "model">model</form:label>
                        </td>
                        <td>
                            <form:input path = "model" />
                        </td>
                        <td><form:errors cssStyle="color: red" path = "model" cssClass = "error" /></td>
                    </tr>
                    <tr>
                        <td>                <form:label path = "type">CAR TYPE</form:label></td>

                        <td><form:select  path="type">
                            <form:options cssStyle=" width: 150px" items="${types}"></form:options>
                        </form:select>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <form:label path = "millage">mileage</form:label>
                        </td>
                        <td>
                            <form:input path = "millage" />
                        </td>
                        <td><form:errors cssStyle="color: red" path = "millage" cssClass = "error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path = "power">enginePower</form:label>
                        </td>
                        <td>
                            <form:input path = "power" />
                        </td>
                        <td><form:errors cssStyle="color: red" path = "power" cssClass = "error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path = "price">price</form:label>
                        </td>
                        <td>
                            <form:input path = "price" />
                        </td>
                        <td><form:errors cssStyle="color: red" path = "price" cssClass = "error" /></td>
                    </tr>
                    <tr>
                        <td>                <form:label path = "colour">COLOUR</form:label></td>

                        <td><form:select  path="colour">
                            <form:options cssStyle=" width: 150px" items="${colours}"></form:options>
                        </form:select>
                        </td>

                    </tr>

                    <tr>
                        <td colspan = "2">
                            <input type = "submit" value = "Add car">
                        </td>
                    </tr>


                </table>
            </form:form>
        </div>
    </div>
</div>



<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>


</html>