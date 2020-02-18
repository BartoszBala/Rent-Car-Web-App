<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/menagment">Menagment</a></li>
            <li><a href="/admin">Admin</a></li>
            <li><a href="/all">ALL USER</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Rejestracja</a></li>

            <c:if test="${!isAuthenticated}"> <li><a href="/login2"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
            <c:if test="${isAuthenticated}">><li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logut</a></li></c:if>
        </ul>
    </div>
</nav>