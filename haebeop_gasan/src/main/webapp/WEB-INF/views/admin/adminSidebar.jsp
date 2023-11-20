<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="sidePath" value='<%=pageContext.getServletContext().getContextPath()%>' />

<aside class="sticky-top me-3" style="position: sticky; top: 2rem; float: left; z-index: auto;">
    <ul class="list-group" style="width: fit-content;">
        <li class="list-group-item"><a href="${sidePath}/admin/adminBoard">관리자 보드</a></li>
        <li class="list-group-item" aria-current="true"><a href="${sidePath}/admin/adminMemberList">회원 관리</a></li>
        <li class="list-group-item"><a href="${sidePath}/">공지 관리</a></li>
        <li class="list-group-item"><a href="${sidePath}/">자유게시판 관리</a></li>
        <li class="list-group-item"><a href="${sidePath}/">배송 관리</a></li>
    </ul>
</aside>