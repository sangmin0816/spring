<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<c:set var="sid" value="${pageContext.session.getAttribute('sid') }"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법::공지사항</title>
    <%@include file="../../include/head.jsp"%>
</head>
<body>
<%@include file="../../include/header.jsp"%>

<div class="container mt-3">
    <jsp:include page="../courseSidebar.jsp">
        <jsp:param name="courseNo" value="${courseNo}"/>
    </jsp:include>

    <div class="row gutters-sm" style="margin-top: 2rem; justify-content: space-around;">
    <div class="container boardTemplate">
        <jsp:include page="../searchCourseBoard.jsp">
            <jsp:param name="courseNo" value="${courseNo}"/>
            <jsp:param name="formLink" value="${rootPath }/courseNotice/courseNoticeList"/>
        </jsp:include>

        <table class="table">
            <thead>
            <tr>
                <th class="has-text-white has-text-centered">글번호</th>
                <th class="has-text-white has-text-centered">제목</th>
                <th class="has-text-white has-text-centered">작성일</th>
                <th class="has-text-white has-text-centered">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${noticeList }" var="notice" varStatus="status">
                <tr>
                    <td class="has-text-centered">${status.count }</td>
                    <td class="has-text-centered"><a href="${rootPath }/notice/noticeGet?no=${notice.noticeNo }">${notice.title }</a></td>
                    <td class="has-text-centered">
                        <fmt:parseDate value="${notice.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="has-text-centered">${notice.visited }</td>
                </tr>
            </c:forEach>
            <c:if test="${empty noticeList}">
                <tr>
                    <td class="has-text-centered" colspan="4">해당 목록이 존재하지 않습니다.</td>
                </tr>
            </c:if>
            </tbody>
        </table>

        <%--  페이지네이션 --%>
        <jsp:include page="../coursePagination.jsp">
            <jsp:param name="pageLink" value="${rootPath }/courseNotice/courseNoticeList?courseNo=${courseNo}"/>
        </jsp:include>
    </div>

    <section class="section blog-wrap container">
        <c:if test='${sid eq "admin"}'>
        <div class="btns is-centered">
            <a href="${rootPath }/notice/noticeInsert" class="btn is-mainColor">공지 등록</a>
        </div>
        </c:if>
    </section>
    </div>
</div>


</body>
</html>

