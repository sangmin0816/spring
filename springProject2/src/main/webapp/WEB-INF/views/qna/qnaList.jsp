<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../include/head.jsp" %>
    <link rel="stylesheet" href="${rootPath}/resources/css/sub.css">
    <style>
        a .answers {padding-left:30px;}
    </style>
</head>

<body>
<%@ include file="../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-02">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">Q & A</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="container boardTemplate">
        <%--  검색 --%>
        <jsp:include page="../include/searchBoard.jsp">
            <jsp:param name="formLink" value="${rootPath}/qna/qnaList"/>
        </jsp:include>

        <table class="table">
            <thead>
            <tr>
                <th class="has-text-centered has-text-white">글번호</th>
                <th class="has-text-centered has-text-white">제목</th>
                <th class="has-text-centered has-text-white">작성자</th>
                <th class="has-text-centered has-text-white">작성일</th>
                <th class="has-text-centered has-text-white">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="qna" items="${qnaList}" varStatus="status">
                <tr>
                    <td class="has-text-centered">${status.count}</td>
                    <c:if test='${qna.lev == 0}'>
                        <td class="has-text-centered"><a href="${rootPath}/qna/qnaGet=?qno=${qna.qno}">${qna.title}</a></td>
                    </c:if>
                    <c:if test='${qna.lev == 1}'>
                        <td class="has-text-centered"><a class="answers" href="${rootPath}/qna/qnaGet=?qno=${qna.qno}">└ [답변]${qna.title}</a></td>
                    </c:if>
                    <td class="has-text-centered">${qna.author}</td>
                    <td class="has-text-centered">
                        <fmt:parseDate value="${qna.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="has-text-centered">${qna.visited}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty qnaList}">
                <tr>
                    <td class="has-text-centered" colspan="5">해당 목록이 존재하지 않습니다.</td>
                </tr>
            </c:if>
            </tbody>
        </table>

        <%--  페이지네이션 --%>
        <jsp:include page="../include/pagination.jsp">
            <jsp:param name="pageLink" value="${rootPath}/qna/qnaList"/>
        </jsp:include>

    </div>

    <c:if test="${not empty sid || (sid eq 'admin')}">
        <div class="buttons is-centered">
            <a href="${rootPath}/qna/qnaInsert=?lev=0&par=0" class="button is-mainColor">문의하기</a>
        </div>
    </c:if>

</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>