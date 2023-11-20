<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../../include/head.jsp" %>
    <style>
        a .answers {padding-left:30px;}
    </style>
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
                <jsp:param name="formLink" value="${rootPath }/courseQna/courseQnaList"/>
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
                <c:forEach var="courseQna" items="${courseQnaList}" varStatus="status">
                    <tr>
                        <td class="has-text-centered">${status.count}</td>
                        <c:if test='${courseQna.lev == 0}'>
                            <td class="has-text-centered"><a href="${rootPath}/courseQna/courseQnaGet?qno=${courseQna.qnaNo}&courseNo=${courseNo}">${courseQna.title}</a></td>
                        </c:if>
                        <c:if test='${courseQna.lev == 1}'>
                            <td class="has-text-centered"><a class="answers" href="${rootPath}/courseQna/courseQnaGet?qno=${courseQna.qnaNo}&courseNo=${courseNo}">└ [답변]${courseQna.title}</a></td>
                        </c:if>
                        <td class="has-text-centered">${courseQna.id}</td>
                        <td class="has-text-centered">
                            <fmt:parseDate value="${courseQna.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
                            <fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
                        </td>
                        <td class="has-text-centered">${courseQna.visited}</td>
                    </tr>
                </c:forEach>

                <c:if test="${empty courseQnaList}">
                    <tr>
                        <td class="has-text-centered" colspan="5">해당 목록이 존재하지 않습니다.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
    
            <%--  페이지네이션 --%>
                <jsp:include page="../coursePagination.jsp">
                    <jsp:param name="pageLink" value="${rootPath}/courseQna/courseQnaList?courseNo=${courseNo}"/>
                </jsp:include>
    
        </div>

        <c:if test="${not empty sid}">
        <div class="btns is-centered">
            <a href="${rootPath}/courseQna/courseQnaInsert=?lev=0&par=0" class="btn btn-primary">문의하기</a>
        </div>
        </c:if>
    </div>

</div>
</body>
</html>