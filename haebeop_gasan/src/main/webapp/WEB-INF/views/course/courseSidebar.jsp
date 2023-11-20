<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="courseNo" value='<%=request.getParameter("courseNo")%>' />
<c:set var="sidePath" value='<%=pageContext.getServletContext().getContextPath()%>' />


<aside class="sticky-top me-3" style="position: sticky; top: 2rem; float: left; z-index: auto;">
    <ul class="list-group" style="width: fit-content;">
        <li class="list-group-item"><a href="${sidePath}/course/courseList">수강목록</a></li>
        <li class="list-group-item" aria-current="true"><a href="${sidePath}/course/courseGet?courseNo=${courseNo}">Course Board</a></li>
        <li class="list-group-item"><a href="${sidePath}/courseAttendance/courseAttendanceList?courseNo=${courseNo}">Course Attendance</a></li>
        <li class="list-group-item"><a href="${sidePath}/courseMaterials/courseMaterialsList?courseNo=${courseNo}">Course Materials</a></li>
        <li class="list-group-item"><a href="${sidePath}/courseNotice/courseNoticeList?courseNo=${courseNo}">Course Notice</a></li>
        <li class="list-group-item"><a href="${sidePath}/courseQna/courseQnaList?courseNo=${courseNo}">Course Qna</a></li>
    </ul>
</aside>