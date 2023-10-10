<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>그로우앤조이::관리자페이지-회원관리</title>
    <%@ include file="../include/head.jsp" %>

</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="content container">
    <h2 class="is-center">회원 정보</h2>
    <nav class="breadcrumb is-right" aria-label="breadcrumbs">
        <ul>
            <li><a href="#">Bulma</a></li>
            <li><a href="#">Documentation</a></li>
            <li><a href="#">Components</a></li>
            <li class="is-active"><a href="#" aria-current="page">Breadcrumb</a></li>
        </ul>
    </nav>

    <table class="table tb1">
        <thead>
        <tr>
            <th class="num"></th>
            <th>이름</th>
            <th>아이디</th>
            <th>전화번호</th>
            <th>가입일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${memberList }" var="member" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${member.name}</td>
                <td><a href="${headPath }/member/get.do?id=${member.id}">${member.id}</a></td>
                <td>${member.tel}</td>
                <td>${member.regdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
