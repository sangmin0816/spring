<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="headPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>공지사항 상세보기</title>
    <jsp:include page="../include/head.jsp" />
    <link rel="stylesheet" href="${headPath}/resources/css/admin.css">
</head>

<body>
<jsp:include page="../include/headerAdmin.jsp" />
<div class="admin_contents_area">
    <jsp:include page="./adminBoardList.jsp" />
    <div class="container contents_area">
        <h1 class="is-size-3 has-text-weight-semibold">공지사항 상세보기</h1>
        <div class="container">
            <table class="table tb2">
                <tbody>
                <tr>
                    <th class="has-text-centered">글 번호</th>
                    <td>${notice.no }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">글 제목</th>
                    <td>${notice.title }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">글 내용</th>
                    <td>${notice.content }</td>
                </tr>
                <tr>
                    <th class="has-text-centered">작성일시</th>
                    <td>
                        <fmt:parseDate value="${notice.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                    </td>
                </tr>
                <tr>
                    <th class="has-text-centered">읽은 횟수</th>
                    <td>${notice.visited }</td>
                </tr>
                </tbody>
            </table>
            <div class="buttons is-right">
                <a class="button is-mainColor" href="${headPath }/admin/List.do">글 목록</a>
                <a class="button is-success" href="${headPath }/admin/Update.do?no=${notice.no}">글 수정</a>
                <a class="button is-mainColor" href="${headPath }/admin/Delete.do?no=${notice.no}">글 삭제</a>
            </div>
        </div>
    </div>
</div>

</body>

</html>
