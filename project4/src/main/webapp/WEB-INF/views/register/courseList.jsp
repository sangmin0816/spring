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

    <div class="row gutters-sm" style="margin-top: 2rem; justify-content: space-between;">
        <c:forEach items="${courseList}" var="course">
            <div class="card mb-3" style="width: 22rem;">
                <a href="${rootPath}/register/courseGet?courseNo=${course.course.courseNo}">
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
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>