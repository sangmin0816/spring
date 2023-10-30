<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="headerPath" value="${pageContext.request.contextPath}"/>
<c:set var="sid" value='<%=session.getAttribute("sid")%>' />
<c:set var="smembership" value='<%=session.getAttribute("smembership")%>' />

<header>
    <nav class="navbar-expand-lg navbar bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${headerPath}/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link" href="${headerPath}/">회사소개</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${headerPath}/course/courseList">강의</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${headerPath }/reservation/academyMapList">상담 신청</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            커뮤니티
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${headerPath}/notice/noticeList">공지사항</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/qna/qnaList">Qna</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/free/freeList">자유게시판</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${headerPath}/dataBoard/dataBoardList">자료실</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            이벤트
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${headerPath}/">출석체크</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/">투표</a></li>
                        </ul>
                    </li>
                </ul>

                <div class="d-flex">
                <c:choose>
                    <c:when test="${not empty sid}">
                        <a href="${headerPath}/member/logout" class="btn btn-outline-light" style="margin: 0px 5px;">Logout</a>
                        <a href="${headerPath}/member/memberGet" class="btn btn-outline-light" style="margin: 0px 5px;">Mypage</a>
                        <c:if test="${smembership eq 'admin'}">
                            <a href="${headerPath}/admin/" class="btn btn-outline-light" style="margin: 0px 5px;">Admin Page</a>
                        </c:if>
                        <c:if test="${smembership eq 'teacher'}">
                            <a href="${headerPath}/teacher/" class="btn btn-outline-light" style="margin: 0px 5px;">Teacher Page</a>
                        </c:if>
                        <c:if test="${smembership eq 'academy'}">
                            <a href="${headerPath}/academy/academyAdminList" class="btn btn-outline-light" style="margin: 0px 5px;">학원 관리</a>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="${headerPath}/member/login" class="btn btn-outline-light" style="margin: 0px 5px;">Login</a>
                        <a href="${headerPath}/member/join" class="btn btn-outline-light" style="margin: 0px 5px;">Join</a>
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
    </nav>
</header>