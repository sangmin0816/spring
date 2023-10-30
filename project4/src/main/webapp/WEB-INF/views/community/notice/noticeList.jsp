<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법::공지사항</title>
    <%@include file="../../include/head.jsp"%>
</head>
<body>
<%@include file="../../include/header.jsp"%>

<div class="content">
    <section class="page-title bg-02">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">공지사항</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="container boardTemplate">
        <jsp:include page="../../include/searchBoard.jsp">
            <jsp:param name="formLink" value="${rootPath}/notice/noticeList"/>
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
                    <td class="has-text-centered"><a href="${rootPath}/notice/noticeGet?no=${notice.noticeNo }">${notice.title }</a></td>
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
        <jsp:include page="../../include/pagination.jsp">
            <jsp:param name="pageLink" value="${rootPath}/notice/noticeList"/>
        </jsp:include>
    </div>

    <section class="section blog-wrap container">




        <c:if test='${sid eq "admin"}'>
        <div class="btns is-centered">
            <a href="${rootPath}/notice/noticeInsert" class="btn is-mainColor">공지 등록</a>
        </div>
        </c:if>




    </section>
</div>


</body>
</html>

