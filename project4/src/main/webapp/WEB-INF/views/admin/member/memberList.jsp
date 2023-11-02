<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="headPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원 목록</title>
    <%@include file="../../include/head.jsp"%>
    <style>
        table {width: 100%; text-align: center;}
    </style>
</head>

<%
    List<String> searchList = new ArrayList<>();
    searchList.add("id");
    searchList.add("membership");
    searchList.add("name");
    request.setAttribute("searchList", searchList);
%>

<body>
<jsp:include page="../../include/header.jsp" />
<div class="content container">
    <jsp:include page="../adminSidebar.jsp" />

    <div class="row gutters-sm" style="margin-top: 2rem; justify-content: space-between;">
        <h1 class="is-size-3 has-text-weight-semibold">회원</h1>

        <div class="container">
            <%--  검색 --%>
            <jsp:include page="../../include/searchList.jsp">
                <jsp:param name="selectOptions" value="id:아이디,membership:회원등급,name:이름"/>
                <jsp:param name="formLink" value="${rootPath}/admin/adminMemberList"/>
            </jsp:include>

            <table class="table">
                <thead>
                <tr>
                    <th class="item1 has-text-white has-text-centered">회원 등급</th>
                    <th class="item2 has-text-white has-text-centered">아이디</th>
                    <th class="item3 has-text-white has-text-centered">이름</th>
                    <th class="item4 has-text-white has-text-centered">포인트</th>
                    <th class="item5 has-text-white has-text-centered">등록일</th>
                    <th class="item5 has-text-white has-text-centered">휴면여부</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="member" items="${memberList}" varStatus="status">
                <tr id="${status.count}">
                    <td class="item1">${member.membership}</td>
                    <td class="item2">
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${headPath }/admin/adminMemberGet?id=${member.id}" style="display:inline-block; width:100%;">${member.id}</a>
                    </td>
                    <td class="item3">${member.name}</td>
                    <td class="item4">${member.point}</td>
                    <td class="item5">
                        <fmt:parseDate value="${member.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="item6">${member.active? "활동":"휴면"}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>

            <jsp:include page="../../include/pagination.jsp">
                <jsp:param name="pageLink" value="${rootPath}/admin/adminMemberList"/>
            </jsp:include>
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