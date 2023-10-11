<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../include/head.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>

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
                <td class="item2 has-text-centered">${dto.title}</td>
                <td class="item3 has-text-centered">
                    <fmt:parseDate value="${dto.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                </td>
                <td class="item4 has-text-centered">${dto.visited}</td>
            </tr>
            <c:if test="${!empty dataFiles}">
            <tr>
                <td colspan="3">
                    <c:forEach var="file" items="${dataFiles}">
                        <div class="dataBoardFile">
                            <a href="${rootPath}/resources/upload/${file.saveFolder}/${file.saveName}" download="${file.fileName}"><i class="icofont-ui-file mr-2"></i>${file.fileName}</a>
                        </div>
                    </c:forEach>
                </td>
            </tr>
            </c:if>
            <tr>
                <td colspan="3" id="content">
                    ${dto.content}
                </td>
            </tr>
            </tbody>
        </table>
        <div class="buttons is-centered">
            <a href="${rootPath}/dataBoard/dataBoardList" class="button is-mainColor">글 목록</a>
            <c:if test="${not empty sid && (sid eq 'admin' || dto.author eq sid)}">
                <a href="${rootPath}/dataBoard/dataBoardUpdate?bno=${dto.bno}&author=${dto.author}" class="button is-success">글 수정</a>
                <a href="${rootPath}/dataBoard/dataBoardDelete?bno=${dto.bno}&author=${dto.author}" class="button is-mainColor">글 삭제</a>
            </c:if>
        </div>
    </section>


</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>