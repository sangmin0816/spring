<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>HaeBeop</title>
    <%@include file="../include/head.jsp"%>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div class="content mt-3">

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

    <div class="container boardTemplate">
        <%--  검색 --%>
        <jsp:include page="../include/searchBoard.jsp">
            <jsp:param name="formLink" value="${rootPath }/dataBoard/dataBoardList"/>
        </jsp:include>

        <table class="table table-secondary" id="tb1">
            <thead>
            <tr>
                <th class="item1 has-text-centered has-text-white">번호</th>
                <th class="item2 has-text-centered has-text-white">제목</th>
                <th class="item3 has-text-centered has-text-white">작성일</th>
                <th class="item4 has-text-centered has-text-white">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="fileboard" items="${fileboardList}" varStatus="status">
                <tr>
                    <td class="item1 has-text-centered">${status.count}</td>
                    <td class="item2 has-text-centered">
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath }/dataBoard/dataBoardGet?bno=${fileboard.bno}" style="display:inline-block; width:100%;">${fileboard.title}</a>
                    </td>
                    <td class="item3 has-text-centered">
                        <fmt:parseDate value="${fileboard.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="item4 has-text-centered">${fileboard.visited}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty fileboardList}">
                <tr>
                    <td colspan="4" class="has-text-centered">해당 목록이 존재하지 않습니다.</td>
                </tr>
            </c:if>
            </tbody>
        </table>

        <%--  페이지네이션 --%>
        <jsp:include page="../include/pagination.jsp">
            <jsp:param name="pageLink" value="${rootPath }/dataBoard/dataBoardList"/>
        </jsp:include>
    </div>

    <c:if test="${not empty sid || (sid eq 'admin')}">
        <div class="buttons is-centered">
            <a href="${rootPath }/dataBoard/dataBoardInsert" class="button is-mainColor">글쓰기</a>
        </div>
    </c:if>

</div>

</body>
</html>
