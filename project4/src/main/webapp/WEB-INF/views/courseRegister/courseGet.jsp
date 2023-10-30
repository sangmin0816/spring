<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HaeBeop</title>
    <%@include file="../include/head.jsp"%>
    <style>
        a {color: inherit; text-decoration: none;}
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <%@include file="sidebar.jsp"%>

    <div class="row gutters-sm" style="margin-top: 2rem;">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">
                    <c:choose>
                        <c:when test="${not empty course.teacherImg.savePath}">
                            <img src="${rootPath}/resource/upload/${course.teacherImg.savePath}/${course.teacherImg.saveName}" alt="${course.teacherImg.originName}" class="rounded-circle" width="40">
                        </c:when>
                        <c:otherwise>
                            <img src="${rootPath}/resource/image/profile_default.jpg" alt="default profile" class="rounded-circle" width="40">
                        </c:otherwise>
                    </c:choose>
                        ${course.course.title}
                </h5>
                <h6 class="card-subtitle mb-2 text-body-secondary">${course.teacher.name}</h6>
                <p class="card-text">${course.course.price}원</p>
                <p class="card-text">잔여인원: ${course.remains}명</p>
                <p class="card-text">${course.course.content}</p>
                <div class="d-flex justify-content-end">
                    <c:if test="${not empty course.video}"><button class="btn btn-info">맛보기</button></c:if>
                    <c:if test="${course.registered eq 0}">
                        <a href="${rootPath}/register/registerInsert?courseNo=${course.course.courseNo}" class="btn btn-primary">수강신청</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>