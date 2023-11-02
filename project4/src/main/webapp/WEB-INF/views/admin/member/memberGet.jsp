<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원 목록</title>
    <%@include file="../../include/head.jsp"%>
</head>
<body>
<%@include file="../../include/header.jsp"%>
<div class="container content">
    <jsp:include page="../adminSidebar.jsp" />

    <div class="row gutters-sm" style="margin-top: 2rem; justify-content: space-around;">
        <h1 class="is-size-3 has-text-weight-semibold">회원 정보</h1>

        <div class="page_wrap">
            <table class="table tb2">
                <tbody>
                <tr>
                    <th class="has-text-centered">아이디</th>
                    <td>${member.id}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">이름</th>
                    <td>${member.name}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">이메일</th>
                    <td>${member.email}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">전화번호</th>
                    <td>${member.tel}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">주소</th>
                    <td>${member.addr1} ${member.addr2} ${member.postcode}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">생년월일</th>
                    <td>${member.birth}</td>
                </tr>
                <tr>
                    <th class="has-text-centered">포인트</th>
                    <td>${member.point}</td>
                </tr>
                </tbody>
            </table>
            <div class="btns is-right">
                <button class="btn btn-danger" type="button" onclick="remove()">회원 비활성화</button>
                <a class="btn bnt-success" href="${rootPath}/admin/adminMemberList">회원 목록</a>
            </div>
        </div>
    </div>

</div>

</body>

<script>
    function remove() {
        if(window.confirm("해당 회원을 비활성화시키겠습니까?")){
            location.href = "${rootPath}/admin/adminMemberDeactive?id=${member.id}"
        }
    }
</script>

</html>
