<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="headPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::공지사항</title>
    <%@include file="../../include/head.jsp"%>
    <link rel="stylesheet" href="${headPath}/resources/css/admin.css">
</head>
<body>
<jsp:include page="../../include/headerAdmin.jsp" />
<div class="admin_contents_area">
    <jsp:include page="../adminBoardList.jsp" />
    <div class="container contents_area2">
        <div class="btns is-right">
            <a href="${headPath}/notice/List.do" class="btn is-mainColor">사용자 홈페이지 이동</a>
        </div>
        <h1 class="is-size-3 has-text-weight-semibold">공지사항</h1>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th class="item1 has-text-centered has-text-white">번호</th>
                        <th class="item2 has-text-centered has-text-white">제목</th>
                        <th class="item3 has-text-centered has-text-white">작성일</th>
                        <th class="item4 has-text-centered has-text-white">조회</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${noticeList }" var="notice" varStatus="status">
                    <tr>
                        <td class="item1 has-text-centered">${status.count }</td>
                        <td class="item2 has-text-centered"><a href="${headPath }/admin/Get.do?no=${notice.noticeNo }">${notice.title }</a></td>
                        <td class="item3 has-text-centered">
                            <fmt:parseDate value="${notice.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                            <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                        </td>
                        <td class="item4 has-text-centered">${notice.visited }</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty noticeList }">
                    <tr>
                        <td colspan="4" class="has-text-centered">해당 목록이 존재하지 않습니다.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
            <div class="btns is-right">
                <a href="${headPath }/admin/Insert.do" class="btn is-mainColor">공지 등록</a>
            </div>
        </div>
    </div>
</body>
</html>

