<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="rootPath" value="<%=request.getContextPath() %>" />

<style>
    .nav-pills-admin .nav-link-side {
        background: 0 0;
        border: 0;
        border-radius: 0.25rem;
    }

    .nav-link-side {
        display: block;
        padding: 0.5rem 1rem;
        color: #0d6efd;
        text-decoration: none;
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
    }

    .nav-pills-admin>li {
        float: none;
    }

    .bg-dark-admin {
        background-color: rgb(33,37,41);
        --bs-bg-opacity: 1;
    }

    .text-white{color: white}

    .p-3 {
        padding: 1rem!important;
    }

</style>

<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark-admin" style="width: 280px">
    <span class="fs-4">관리자페이지</span>
    <hr>
    <ul class="nav nav-pills-admin flex-column mb-auto">
        <li class="nav-item">
            <a id="admin-member-nav" href="${rootPath}/admin/MemberListAdmin.do" class="nav-link-side px-0 text-white">
                회원 관리
            </a>
        </li>
        <li class="nav-item">
            <a id="admin-notice-nav" href="${rootPath}/admin/List.do" class="nav-link-side px-0 text-white">
                공지사항 관리
            </a>
        </li>
        <li class="nav-item">
            <a id="admin-file-nav" href="${rootPath}/admin/FreeListAdmin.do" class="nav-link-side px-0 text-white">
                자유게시판 관리
            </a>
        </li>
        <li class="nav-item">
            <a id="admin-vote-nav" href="${rootPath}/admin/VoteMemberListAdmin.do" class="nav-link-side px-0 text-white">
                투표 관리
            </a>
        </li>
    </ul>
</div>

<script>
    var link =  document.location.href;
    let nav;
    if(link.includes("Member")){
        nav = $("#admin-member-nav");
        $(nav).attr("aria-current", "page");
        $(nav).addClass("active");
    } else if(link.includes("Notice")){
        nav = $("#admin-notice-nav");
        $(nav).attr("aria-current", "page");
        $(nav).addClass("active");
    } else if(link.includes("File")){
        nav = $("#admin-file-nav");
        $(nav).attr("aria-current", "page");
        $(nav).addClass("active");
    } else if(link.includes("Vote")){
        nav = $("#admin-file-nav");
        $(nav).attr("aria-current", "page");
        $(nav).addClass("active");
    } else {
        nav = $("#admin-member-nav");
        $(nav).attr("aria-current", "page");
        $(nav).addClass("active");
    }
</script>
