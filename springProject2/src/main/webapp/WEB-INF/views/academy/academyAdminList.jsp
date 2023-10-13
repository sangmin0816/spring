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
        .card {
            width:40%; display: inline-block
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <%@include file="sidebar.jsp"%>

    <div class="row gutters-sm" style="margin-top: 2rem;">
        <div class="container">
            <c:forEach items="${academyList}" var="academy">
            <div class="card mb-3 me-3">
                <div class="card-body">
                    <h5 class="card-title">${academy.name}</h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">${academy.address}</h6>
                    <p class="card-text">
                        전화번호: ${academy.tel}<br>
                        이메일: ${academy.email}<br>
                        영업시간: ${academy.opentime} ~ ${academy.closetime}
                    </p>
                    <a class="btn btn-info" href="${rootPath}/academy/academyUpdate?ano=${academy.ano}">정보 수정</a>
                </div>
            </div>
            </c:forEach>
            <c:if test="${empty academyList}">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">등록된 학원이 없습니다. 학원을 추가해주세요.</h5>
                    </div>
                </div>
            </c:if>
            <div></div>
            <a class="btn btn-primary" href="${rootPath}/academy/academyInsert">학원 추가하기</a>
        </div>
    </div>
</div>
</body>
</html>

<script>
</script>