<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../../include/head.jsp" %>
</head>
<body>
<%@ include file="../../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-04">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">학습 자료실</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="section blog-wrap container">
        <table class="table">
            <thead>
            <tr>
                <th class="item2 has-text-white has-text-centered">제목</th>
                <th class="item3 has-text-white has-text-centered">작성일</th>
                <th class="item4 has-text-white has-text-centered">조회수</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="item2 has-text-centered">${courseMaterials.title}</td>
                <td class="item3 has-text-centered">
                    <fmt:parseDate value="${courseMaterials.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                </td>
                <td class="item4 has-text-centered">${courseMaterials.visited}</td>
            </tr>
            <c:if test="${!empty storages}">
            <tr>
                <td colspan="3">
                    <c:forEach var="file" items="${storages}">
                        <div class="courseMaterialsFile">
                            <a href="${rootPath}/resources/upload/${file.savePath}/${file.saveName}" download="${file.originName}"><i class="icofont-ui-file mr-2"></i>${file.originName}</a>
                        </div>
                    </c:forEach>
                </td>
            </tr>
            </c:if>
            <tr>
                <td colspan="3" id="content">
                    ${courseMaterials.content}
                </td>
            </tr>
            </tbody>
        </table>
        <div class="btns is-centered">
            <a href="${rootPath}/courseMaterials/courseMaterialsList?courseNo=${courseNo}" class="btn btn-primary">글 목록</a>
            <c:if test="${not empty sid && (sid eq 'admin' || courseMaterials.id eq sid)}">
                <a href="${rootPath}/courseMaterials/courseMaterialsUpdate?bno=${courseMaterials.materialNo}&author=${courseMaterials.id}" class="btn is-success">글 수정</a>
                <a href="${rootPath}/courseMaterials/courseMaterialsDelete?bno=${courseMaterials.materialNo}&author=${courseMaterials.id}" class="btn is-mainColor">글 삭제</a>
            </c:if>
        </div>
    </section>


</div>

</body>
</html>