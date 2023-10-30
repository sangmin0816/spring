<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<title>해법</title>
	<%@ include file="../include/head.jsp" %>
	<style>
		a .answers {padding-left:30px;}
	</style>
</head>

<body>
<header class="hd" id="hd">
	<jsp:include page="../include/header.jsp" />
</header>

<div class="content mt-3">
	<section class="page-title bg-02">
		<div class="container">
			<div class="columns">
				<div class="column is-12">
					<div class="block has-text-centered">
						<h1 class="is-capitalize text-lg font-happy">강의 목록</h1>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="container boardTemplate">
		<%--  검색 --%>
		<jsp:include page="../include/searchBoard.jsp">
			<jsp:param name="formLink" value="${rootPath}/course/courseList"/>
		</jsp:include>

		<table class="table">
			<thead>
			<tr>
				<th class="has-text-centered has-text-white">번호</th>
				<th class="has-text-centered has-text-white">제목</th>
				<th class="has-text-centered has-text-white">선생님</th>
				<th class="has-text-centered has-text-white">가격</th>
				<th class="has-text-centered has-text-white">정원</th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${not empty courseList }">
				<c:forEach items="${courseList }" var="course" varStatus="status">
					<tr>
						<td class="has-text-centered">${status.count }</td>
						<td class="has-text-centered"><a href="${path}/course/courseGet?courseNo=${course.courseNo }">${course.title }</a></td>
						<td class="has-text-centered">${course.teacher}</td>
						<td class="has-text-centered">${course.price}</td>
						<td class="has-text-centered">${course.capacity}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty courseList }">
				<tr>
					<td class="has-text-centered" colspan="5">강의목록이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>

		<%-- 페이징처리 --%>
		<jsp:include page="../include/pagination.jsp">
			<jsp:param name="pageLink" value="${rootPath}/course/courseList"/>
		</jsp:include>
	</div>

		<c:if test="${not empty sid}">
			<div class="buttons is-centered">
				<a class="button is-mainColor" href="${rootPath}/course/courseInsert">글쓰기</a>
			</div>
		</c:if>
	</div>
</body>
</html>