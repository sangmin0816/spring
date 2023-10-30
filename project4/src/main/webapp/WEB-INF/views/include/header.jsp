<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="headerPath" value="<%=pageContext.getServletContext().getContextPath()%>"/>

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
                        <a class="nav-link" href="${headerPath}/">학원 소개</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${headerPath}/register/courseList">수강신청</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            나의 학습
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${headerPath}/course/courseList">강의실</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/">수강 관리</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            커뮤니티
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${headerPath}/notice/noticeList">공지사항</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/free/freeList">자유게시판</a></li>
                            <li><a class="dropdown-item" href="${headerPath}/">이벤트</a></li>
                        </ul>
                    </li>
                </ul>

                <div class="d-flex">
                    <c:choose>
                        <c:when test="${not empty sid}">
                            <a href="${headerPath}/member/logout" class="btn btn-outline-light" style="margin: 0px 5px;">로그아웃</a>
                            <a href="${headerPath}/member/memberGet" class="btn btn-outline-light" style="margin: 0px 5px;">회원 정보</a>
                            <c:if test="${smembership eq 'admin'}">
                                <a href="${headerPath}/admin/" class="btn btn-outline-light" style="margin: 0px 5px;">관리자 페이지</a>
                            </c:if>
                            <c:if test="${smembership eq 'teacher'}">
                                <a href="${headerPath}/teacher/" class="btn btn-outline-light" style="margin: 0px 5px;">선생님 페이지</a>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <a href="${headerPath}/member/login" class="btn btn-outline-light" style="margin: 0px 5px;">로그인</a>
                            <a href="${headerPath}/member/join" class="btn btn-outline-light" style="margin: 0px 5px;">회원가입</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </nav>
</header>