<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--tutaj chyba brakuje metody post w form ale działa --%>
<%--potem stworzę obiekt filtr z kilkoma polami i jego będę przekazywał --%>


<%--@elvariable id="filterDto" type=""--%>
<form:form method="POST" action="/home" modelAttribute="filterDto" >


    <table>
        <tbody>


            <tr>
              <td> <form:checkboxes path="carTypes"   items="${brands}"/>
              </td>
            </tr>

<tr >
            <td colspan="2">
                <input type="submit" value="Filter" />
            </td>
</tr>

        </tbody>
    </table>


<%--    <c:forEach items="${brands}" var="brand">--%>
<%--        <input type="checkbox" id="${brand}" name="carType" value="${brand}">--%>
<%--        <label for="${brand}"> ${brand} </label><br>--%>
<%--    </c:forEach>--%>




</form:form>
