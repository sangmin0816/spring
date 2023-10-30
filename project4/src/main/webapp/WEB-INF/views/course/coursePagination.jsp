<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:set var="pageLink" value='<%=request.getParameter("pageLink")%>' />

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:if test="${curPage > page.pageCount }">
        <li class="page-item previous">
            <a class="page-link" href="${pageLink}&page=${page.blockStartNum - 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
        </li>
        </c:if>

        <c:forEach var="i" begin="${page.blockStartNum }" end="${page.blockLastNum }">
            <c:choose>
                <c:when test="${i == curPage }">
                    <li class="page-item active" aria-current="page"><a class="page-link" href="${pageLink}&page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>">${i }</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="${pageLink}&page=${i }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>">${i }</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page.blockLastNum < page.totalPageCount }">
        <li class="page-item next">
            <a class="page-link" href="${pageLink}&page=${page.blockLastNum + 1 }<c:if test="${!empty keyword }">&type=${type }&keyword=${keyword }</c:if>" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
        </li>
        </c:if>

    </ul>
</nav>