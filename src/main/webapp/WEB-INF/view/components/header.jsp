<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">RentCar</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/service">For Staff Only</a></li>
            <li><a href="/admin">For Admin Only</a></li>
            <li><a href="/orders-history">Your orders</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">


            <c:if test="${!isAuthenticated}">
                <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                <li><a href="/login2"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
            <c:if test="${isAuthenticated}"><li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logut ${user}</a></li></c:if>
        </ul>
    </div>
</nav>