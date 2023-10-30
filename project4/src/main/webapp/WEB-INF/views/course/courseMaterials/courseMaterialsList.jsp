<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>HaeBeop</title>
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
        <%--  검색 --%>
        <jsp:include page="../searchCourseBoard.jsp">
            <jsp:param name="courseNo" value="${courseNo}"/>
            <jsp:param name="formLink" value="${rootPath }/courseMaterials/courseMaterialsList"/>
        </jsp:include>

        <table class="table">
            <thead>
            <tr>
                <th class="item1 has-text-centered has-text-white">번호</th>
                <th class="item2 has-text-centered has-text-white">제목</th>
                <th class="item3 has-text-centered has-text-white">작성일</th>
                <th class="item4 has-text-centered has-text-white">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="courseMaterials" items="${courseMaterialsList}" varStatus="status">
                <tr>
                    <td class="item1 has-text-centered">${status.count}</td>
                    <td class="item2 has-text-centered">
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath}/courseMaterials/courseMaterialsGet?materialNo=${courseMaterials.materialNo}&courseNo=${courseNo}" style="display:inline-block; width:100%;">${courseMaterials.title}</a>
                    </td>
                    <td class="item3 has-text-centered">
                        <fmt:parseDate value="${courseMaterials.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="item4 has-text-centered">${courseMaterials.visited}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty courseMaterialsList}">
                <tr>
                    <td colspan="4" class="has-text-centered">해당 목록이 존재하지 않습니다.</td>
                </tr>
            </c:if>
            </tbody>
        </table>

        <%--  페이지네이션 --%>
        <jsp:include page="../coursePagination.jsp">
            <jsp:param name="pageLink" value="${rootPath }/courseMaterials/courseMaterialsList?courseNo=${courseNo}"/>
        </jsp:include>
    </div>

        <c:if test="${not empty sid || (sid eq 'admin')}">
            <div class="btns is-centered">
                <a href="${rootPath }/courseMaterials/courseMaterialsInsert?courseNo=${courseNo}" class="btn btn-primary">글쓰기</a>
            </div>
        </c:if>
    </div>
</div>

</body>
</html>
