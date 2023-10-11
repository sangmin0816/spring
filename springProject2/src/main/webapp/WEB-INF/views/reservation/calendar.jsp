<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>해법</title>
    <%@ include file="../include/head.jsp" %>
    <style>
        .calendar table{
            table-layout: fixed;
            border-collapse: separate;
            border-spacing: 0;
            border-radius: 4px;
            width: 100%;
            border: 1px solid #ddd;
            min-width: 600px;
        }

        .calendar table td {
            position: relative;
            vertical-align: top;
            border-bottom: 1px solid #ddd;
            border-right: 1px solid #ddd;
        }

        .calendar table th {
            border-bottom: 1px solid #ddd;
            border-right: 1px solid #ddd;
            font-weight: 500;
        }

        .event {
            min-height: 70px;
        }
    </style>
</head>

<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h2>${yyyy}년 ${mm}월 달력</h2>
    <div class="calendar">
        <table class="text-center">
            <thead>
            <tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>
            </thead>
            <tbody>
            <c:forEach items="${calList}" var="cal">
                <tr>
                    <c:forEach items="${cal}" var="day">
                        <td>
                            <div class="day">${day}</div>
                            <div class="event">${event}</div>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>