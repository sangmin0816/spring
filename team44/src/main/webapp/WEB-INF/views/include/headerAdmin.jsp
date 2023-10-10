<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<c:set var="headPath" value="${pageContext.request.contextPath }"/>
<c:set var="sid" value="${pageContext.session.getAttribute('sid') }"/>

<header class="navigation admin">
    <div class="header-top ">
        <div class="mx-5 py-2">
            <div class="columns is-gapless is-justify-content-space-between is-align-items-center">
                <div class="column is-12-desktop is-8-tablet">
                    <div class="header-top-right has-text-right-tablet has-text-centered-mobile">
                        <c:if test="${sid=='admin'}">
                            <a href="${headPath }/" class="is-size-6 has-text-weight-semibold">홈페이지 이동</a>
                            <a href="${headPath }/member/logout.do?sid=${sid}" class="is-size-6 has-text-weight-semibold">로그아웃</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>