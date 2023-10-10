<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${yyyymm} 달력</title>
    <%@include file="../include/head.jsp"%>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div class="container">
    <nav>
        <a href="${rootPath}/calendar/calendar">HOME</a>
        <a href="${rootPath}/calendar/cal1?yyyy=2023">2023년 전체 국경일</a>
        <a href="${rootPath}/calendar/cal2?sunDate=2023-10-01">2023년 10월의 국경일</a>
        <a href="${rootPath}/calendar/cal3?yyyymm=202310">2023년 10월의 달력</a>
    </nav>

    <h2>${yyyymm} 달력</h2>
    <hr>

    <table id="tb1">
        <thead>
        <tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${calList}" var="cal">
            <tr>
                <c:forEach items="${cal}" var="day">
                    <td>${day}</td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


    <script>
    /* $(document).ready(function(){
        $("#tb1 tbody").empty();
        $("#tb1 tbody").append(${cal});
    }); */
    </script>
</body>
</html>
