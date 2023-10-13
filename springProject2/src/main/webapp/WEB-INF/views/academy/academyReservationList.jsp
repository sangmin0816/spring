<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HaeBeop</title>
    <%@include file="../include/head.jsp"%>

    <style>
        td.unavailable {
            background-color: #f1ffd5;
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <%@include file="sidebar.jsp"%>

    <div class="row gutters-sm" style="margin-top: 2rem;">
        <div class="ms-3">
            <table class="table text-center">
                <thead>
                <tr>
                    <th>예약자</th>
                    <th>예약 날짜</th>
                    <th>예약 시간</th>
                    <th>예약 상태</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reservation" items="${reservationList}" varStatus="status">
                    <tr>
                        <td>${reservation.id}</td>
                        <td>${reservation.rdate}</td>
                        <td>${reservation.rtime}</td>
                        <td class="rstate">${reservation.status}</td>
                        <td><a class="btn btn-primary ms-1" href="${rootPath}/academy/academyReservationGet?rno=${reservation.rno}">자세히</a></td>
                    </tr>
                </c:forEach>
                <c:if test="${empty reservationList}">
                    <tr>
                        <td class="has-text-centered" colspan="5">해당 목록이 존재하지 않습니다.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

<script>
    $(document).ready(function(){
        $(".rstate").each(function(){
            switch ($(this).text()){
                case "pending":
                    $(this).text("보류");
                    break;
                case "approve":
                    $(this).text("승인");
                    break;
                case "refusal":
                    $(this).text("거절");
                    break;
            }
        })
    })
</script>