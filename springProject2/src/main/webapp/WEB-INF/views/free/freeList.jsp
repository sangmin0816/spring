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
						<h1 class="is-capitalize text-lg font-happy">자유게시판</h1>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="container boardTemplate">
		<%--  검색 --%>
		<jsp:include page="../include/searchBoard.jsp">
			<jsp:param name="formLink" value="${rootPath}/free/freeList"/>
		</jsp:include>

		<table class="table">
			<thead>
			<tr>
				<th class="has-text-centered has-text-white">글번호</th>
				<th class="has-text-centered has-text-white">제목</th>
				<th class="has-text-centered has-text-white">작성자</th>
				<th class="has-text-centered has-text-white">작성일</th>
				<th class="has-text-centered has-text-white">조회수</th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${not empty freeList }">
				<c:forEach items="${freeList }" var="free" varStatus="status">
					<tr>
						<td class="has-text-centered">${status.count }</td>
						<td class="has-text-centered"><a href="${path}/free/freeGet?fno=${free.fno }">${free.title }</a></td>
						<td class="has-text-centered">${free.author}</td>
						<td class="has-text-centered">
							<fmt:parseDate value="${free.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
						</td>
						<td class="has-text-centered">${free.visited }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty freeList }">
				<tr>
					<td class="has-text-centered" colspan="5">자유게시판에 글이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>

		<%-- 페이징처리 --%>
		<jsp:include page="../include/pagination.jsp">
			<jsp:param name="pageLink" value="${rootPath}/free/freeList"/>
		</jsp:include>
	</div>

		<c:if test="${not empty sid}">
			<div class="buttons is-centered">
				<a class="button is-mainColor" href="${rootPath}/free/freeInsert">글쓰기</a>
			</div>
		</c:if>
	</div>
</body>
</html>