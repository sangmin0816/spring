<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>자유게시판 관리 - 상세보기</title>
    <%@include file="../../include/head.jsp"%>
    <link rel="stylesheet" href="${path}/resources/css/admin.css">
</head>

<body>
<jsp:include page="../../include/headerAdmin.jsp" />
<div class="admin_contents_area">
    <jsp:include page="../adminBoardList.jsp" />
    <div class="container contents_area">
        <div class="column">
            <h1 class="is-size-3 has-text-weight-semibold">자유게시판</h1>
            <table class="table is-fullwidth is-bordered mt-5">
                <colgroup>
                    <col style="width:20%;">
                    <col style="width:auto;">
                </colgroup>
                <tbody>
                <tr>
                    <th class="has-text-centered">제목</th>
                    <td>${dto.title }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">작성자</th>
                    <td>${dto.author }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">내용</th>
                    <td>${dto.content }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">작성일</th>
                    <td>${dto.regdate }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">조회수</th>
                    <td>${dto.visited }</td>
                </tr>
                </tbody>
            </table>

            <div class="dat_list">
                <ul class="mb-5">
                    <c:forEach var="comment" items="${commentList }">
                        <li class="py-2">
                            <div class="dat_area">
                                <p class="dat_info">
                                    <fmt:parseDate value="${comment.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" /><br />
                                    작성자 : ${comment.author}
                                </p>
                                <p class="dat_content">${comment.content}</p>
                                <a class="btn is-primary" href="${path }/comment/delete.do?dno=${comment.dno}&fno=${fno}">해당 댓글 삭제</a>
                            </div>
                        </li>
                    </c:forEach>
                    <c:if test="${empty commentList }">
                        <li>댓글이 존재하지 않습니다.</li>
                    </c:if>

                </ul>
            </div>

            <div class="btns is-right">
                <a class="btn is-mainColor" href="${path }/admin/FreeListAdmin.do">글 목록</a>
                <a class="btn is-success" href="${path }/board/free/delete.do?fno=${dto.fno}&author=${dto.author}">글 삭제</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>