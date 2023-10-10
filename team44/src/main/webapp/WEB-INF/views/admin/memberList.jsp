<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="headPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원 목록</title>
    <jsp:include page="../include/head.jsp" />
    <link rel="stylesheet" href="${headPath}/resources/css/admin.css">
    <style>
        table {width: 100%; text-align: center;}
        .item1 {width: 5%}
        .item2 {width: 25%}
        .item3 {width: 25%}
        .item4 {width: 5%}
        .item5 {width: 40%}
    </style>
</head>

<body>
<jsp:include page="../include/headerAdmin.jsp" />
<div class="admin_contents_area">
    <jsp:include page="./adminBoardList.jsp" />
    <div class="container contents_area">
        <h1 class="is-size-3 has-text-weight-semibold">회원</h1>

        <div class="container">
            <table class="table table-secondary" id="tb1">
                <thead>
                <tr>
                    <th class="item1 has-text-white has-text-centered">번호</th>
                    <th class="item2 has-text-white has-text-centered">아이디</th>
                    <th class="item3 has-text-white has-text-centered">이름</th>
                    <th class="item4 has-text-white has-text-centered">포인트</th>
                    <th class="item5 has-text-white has-text-centered">등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="member" items="${memberList}" varStatus="status">
                <tr id="${status.count}">
                    <td class="item1">${status.count}</td>
                    <td class="item2">
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${headPath }/admin/get.do?id=${member.id}" style="display:inline-block; width:100%;">${member.id}</a>
                    </td>
                    <td class="item3">${member.name}</td>
                    <td class="item4">${member.point}</td>
                    <td class="item5">
                        <fmt:parseDate value="${member.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='5' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>