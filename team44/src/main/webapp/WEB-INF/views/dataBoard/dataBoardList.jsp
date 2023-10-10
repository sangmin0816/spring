<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼</title>
    <%@ include file="../include/head.jsp" %>
    <link rel="stylesheet" href="${headPath }/resources/css/sub.css">
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
        <form action="${headPath }/board/dataBoardList.do" method="get" class="field has-addons has-addons-right">
            <p class="control">
                <span class="select">
                    <select id="type" name="type">
                        <option value="title"<c:if test="${type eq 'title' }"> selected</c:if>>제목</option>
                        <option value="content"<c:if test="${type eq 'content' }"> selected</c:if>>내용</option>
                        <option value="author"<c:if test="${type eq 'author' }"> selected</c:if>>작성자</option>
                    </select>
                </span>
            </p>
            <p class="control">
                <input class="input" type="text" id="keyword" name="keyword" placeholder="검색어를 입력하세요" value="${keyword }">
            </p>
            <p class="control">
                <input type="submit" class="button is-mainColor" value="검색" />
            </p>
        </form>

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
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${headPath }/board/dataBoardGet.do?bno=${fileboard.bno}" style="display:inline-block; width:100%;">${fileboard.title}</a>
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

        <nav class="pagination is-rounded is-centered mb-6" role="navigation" aria-label="pagination">
            <c:if test="${curPage > page.pageCount }">
                <a href="${headPath }/board/dataBoardList.do?page=${page.blockStartNum - 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-previous">Previous</a>
            </c:if>
            <c:if test="${page.blockLastNum < page.totalPageCount }">
                <a href="${headPath }/board/dataBoardList.do?page=${page.blockLastNum + 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-next">Next page</a>
            </c:if>

            <ul class="pagination-list">
                <c:forEach var="i" begin="${page.blockStartNum }" end="${page.blockLastNum }">
                    <c:choose>
                        <c:when test="${i == curPage }">
                            <li>
                                <a href="${headPath }/board/dataBoardList.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link is-current" aria-label="Page ${i }" aria-current="page">${i }</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="${headPath }/board/dataBoardList.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link" aria-label="Page ${i }" aria-current="page">${i }</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
        </nav>
        <c:if test="${not empty sid || (sid eq 'admin')}">
            <div class="buttons is-centered">
                <a href="${headPath }/board/dataBoardInsert.do" class="button is-mainColor">글쓰기</a>
            </div>
        </c:if>
    </section>


</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
