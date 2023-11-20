<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="headPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>이벤트1</title>
    <jsp:include page="../include/head.jsp" />
    <link rel="stylesheet" href="${headPath }/resources/css/sub.css">
</head>
<body>
<div class="wrap">
    <header class="hd" id="hd">
        <jsp:include page="../include/header.jsp" />
    </header>
    <div class="container is-fullhd">

        <section class="section" style="text-align: center">
            <img src="${headPath }/resources/image/main/evnet1.png" alt="수목원">
        </section>
    </div>
    <footer class="ft" id="ft">
        <jsp:include page="../include/footer.jsp" />
    </footer>
</div>
</body>
</html>
