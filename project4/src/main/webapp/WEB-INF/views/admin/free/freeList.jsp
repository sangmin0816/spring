<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>자유게시판 관리</title>
    <%@include file="../../include/head.jsp"%>
    <link rel="stylesheet" href="${path}/resources/css/admin.css">
</head>

<body>
<jsp:include page="../../include/headerAdmin.jsp" />
<div class="admin_contents_area">
    <jsp:include page="../adminBoardList.jsp" />
    <div class="container contents_area2">
        <div class="column">
            <div class="btns is-right">
                <a href="${path}/board/free/list.do" class="btn is-mainColor">사용자 홈페이지 이동</a>
            </div>
            <h1 class="is-size-3 has-text-weight-semibold">자유게시판</h1>
            <form action="${path }/admin/FreeListAdmin.do" method="get" class="field has-addons has-addons-right">
                <p class="control">
                    <span class="select">
                        <select id="type" name="type">
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                            <option value="id">작성자</option>
                        </select>
                    </span>
                </p>
                <p class="control">
                    <input class="input" type="text" id="keyword" name="keyword" placeholder="검색어를 입력하세요" value="${keyword }">
                </p>
                <p class="control">
                    <input type="submit" class="btn is-mainColor" value="검색" />
                </p>
            </form>
            <table class="table is-fullwidth table is-striped mt-5">
                <colgroup>
                    <col style="width:5%;">
                    <col style="width:auto;">
                    <col style="width:15%;">
                    <col style="width:10%;">
                    <col style="width:10%;">
                </colgroup>
                <thead>
                <tr>
                    <th class="has-text-white has-text-centered">글번호</th>
                    <th class="has-text-white has-text-centered">제목</th>
                    <th class="has-text-white has-text-centered">작성자</th>
                    <th class="has-text-white has-text-centered">작성일</th>
                    <th class="has-text-white has-text-centered">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty freeList }">
                    <c:forEach items="${freeList }" var="free" varStatus="status">
                        <tr>
                            <td>${status.count }</td>
                            <td><a href="${path}/admin/freeGet.do?fno=${free.freeNo }">${free.title }</a></td>
                            <td>${free.id}</td>
                            <td>
                                <fmt:parseDate value="${free.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
                            </td>
                            <td>${free.visited }</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty freeList }">
                    <tr>
                        <td class="has-text-centered" colspan="5">자유게시판에 글이 존재하지 않습니다.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>

            <nav class="pagination is-rounded is-centered mb-6" role="navigation" aria-label="pagination">
                <c:if test="${curPage > page.pageCount }">
                    <a href="${path }/admin/FreeListAdmin.do?page=${page.blockStartNum - 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-previous">Previous</a>
                </c:if>
                <c:if test="${page.blockLastNum < page.totalPageCount }">
                    <a href="${path }/admin/FreeListAdmin.do?page=${page.blockLastNum + 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-next">Next page</a>
                </c:if>

                <ul class="pagination-list">
                    <c:forEach var="i" begin="${page.blockStartNum }" end="${page.blockLastNum }">
                        <c:choose>
                            <c:when test="${i == curPage }">
                                <li>
                                    <a href="${path }/admin/FreeListAdmin.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link is-current" aria-label="Page ${i }" aria-current="page">${i }</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${path }/admin/FreeListAdmin.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link" aria-label="Page ${i }" aria-current="page">${i }</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>