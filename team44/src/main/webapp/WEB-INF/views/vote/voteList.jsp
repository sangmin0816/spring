<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::투표</title>
    <jsp:include page="../include/head.jsp" />
    <link rel="stylesheet" href="${path }/resources/css/sub.css">
</head>
<body>
<div class="wrap">
    <header class="hd" id="hd">
        <jsp:include page="../include/header.jsp" />
    </header>

    <section class="page-title bg-03">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">투표</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="container is-fullhd">
        <nav class="breadcrumb is-right" aria-label="breadcrumbs">
            <ul>
                <li><a href="/">HOME</a></li>
                <li class="is-active"><a href="${path }/vote/voteList.jsp" aria-current="page">투표</a></li>
            </ul>
        </nav>
        <section class="section">
            <h2 class="title has-text-centered">티이슈</h2>
            <form action="${path }/vote/list.do" method="get" class="field has-addons has-addons-right">
                <p class="control">
                <span class="select">
                    <select id="type" name="type">
                        <option value="title">제목</option>
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

            <div class="columns is-multiline is-mobile is-four-fifths is-offset-1 mt-5">
                <c:if test="${!empty voteList }">
                    <c:forEach items="${voteList }" var="vote" varStatus="status">
                        <div class="column is-half">
                            <div class="vote_li box<c:if test="${!vote.stateYn }"> finish</c:if>">
                                <a href="${path }/vote/get.do?vno=${vote.vno }">
                                    <h3 class="is-size-3 has-text-weight-semibold"><c:if test="${!vote.stateYn }">[완료]</c:if> ${vote.title }</h3>
                                    <p class="date my-1">${vote.startDate } ~ ${vote.finishDate }</p>
                                    <hr>
                                        <%--
                                        댓글이랑 투표수 추가 예정
                                        <p><span>댓글수 : ${vote.visited }</span> | <span>투표수 : ${vote.visited }</span></p>
                                        --%>
                                    <p><span>조회수 : ${vote.visited }</span></p>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty voteList }">
                    <div class="column is-full has-text-centered">등록된 투표가 없습니다.</div>
                </c:if>
            </div>

            <nav class="pagination is-rounded is-centered mb-6" role="navigation" aria-label="pagination">
                <c:if test="${curPage > page.pageCount }">
                    <a href="${path }/vote/list.do?page=${page.blockStartNum - 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-previous">Previous</a>
                </c:if>
                <c:if test="${page.blockLastNum < page.totalPageCount }">
                    <a href="${path }/vote/list.do?page=${page.blockLastNum + 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-next">Next page</a>
                </c:if>

                <ul class="pagination-list">
                    <c:forEach var="i" begin="${page.blockStartNum }" end="${page.blockLastNum }">
                        <c:choose>
                            <c:when test="${i == curPage }">
                                <li>
                                    <a href="${path }/vote/list.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link is-current" aria-label="Page ${i }" aria-current="page">${i }</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${path }/vote/list.do?page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" class="pagination-link" aria-label="Page ${i }" aria-current="page">${i }</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </nav>
        </section>
    </div>
    <footer class="ft" id="ft">
        <jsp:include page="../include/footer.jsp" />
    </footer>
</div>
</body>
</html>
