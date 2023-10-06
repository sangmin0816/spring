<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="headerPath" value="<%=pageContext.getServletContext().getContextPath()%>"/>

<header>
    <nav class="navbar-expand-lg navbar bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${headerPath}/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link" href="${headerPath}/files/fileupload">Files Upload</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Lectures
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Validation</a></li>
                            <li><a class="dropdown-item" href="${rootPath}/locale/lang1">Locale</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${rootPath}/calendar/calendar">Calendar</a></li>
                            <li><a class="dropdown-item" href="${rootPath}/chat/home">Chat</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">Link</a>
                    </li>
                </ul>

                <div class="d-flex">
                <c:choose>
                    <c:when test="${sid eq 'admin'}">
                        <a href="${headerPath}/user/logout" class="btn btn-outline-light" style="margin: 0px 5px;">Logout</a>
                        <a href="${headerPath}/user/get" class="btn btn-outline-light" style="margin: 0px 5px;">Mypage</a>
                    </c:when>
                    <c:when test="${not empty sid}">
                        <a href="${headerPath}/user/logout" class="btn btn-outline-light" style="margin: 0px 5px;">Logout</a>
                        <a href="${headerPath}/user/get" class="btn btn-outline-light" style="margin: 0px 5px;">Mypage</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${headerPath}/user/login" class="btn btn-outline-light" style="margin: 0px 5px;">Login</a>
                        <a href="${headerPath}/user/join" class="btn btn-outline-light" style="margin: 0px 5px;">Join</a>
                    </c:otherwise>
                </c:choose>

                </div>


                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>