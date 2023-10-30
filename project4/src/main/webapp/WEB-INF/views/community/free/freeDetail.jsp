<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>자유게시판 글 보기</title>
    <!-- 헤드 부분 인클루드 -->
    <%@include file="../../include/head.jsp"%>
</head>

<body>
<%@include file="../../include/header.jsp"%>
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

	<section class="section blog-wrap container">
		<div class="detail">
			<div class="conwrap">
				<div class="h3group">
					<div class="location">
						<span class="depth">홈</span>
						<span class="depth">/ 커뮤니티</span><strong class="this">/ 자유게시판</strong>
					</div>
				</div>
				<div class="viewbody">
					<div class="hgroup">
						<c:if test="${ sid eq 'admin'}">
						<div class="no">NO ${dto.freeNo }</div>
						</c:if>
						<div class="tit">${dto.title }</div>
						<div class="util">
							<div class="name">${dto.id }</div>
							<div class="date">작성일
								<fmt:parseDate value="${comment.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" /></div>
							<div class="hit">조회수 ${dto.visited }</div></div>
						</div>
					<div class="content">
							${dto.content }
					</div>
					<div class="btns is-centered">
						<a class="btn is-mainColor" href="${rootPath}/free/freeList">목록</a>
						<c:if test="${not empty sid && (dto.id eq sid)}">
							<a class="btn is-success" href="${rootPath}/free/freeUpdate?fno=${dto.freeNo}&author=${dto.id}">수정</a>
						</c:if>
						<c:if test="${not empty sid && (sid eq 'admin' || dto.id eq sid)}">
							<a class="btn is-mainColor" href="${rootPath}/free/freeDelete?fno=${dto.freeNo}&author=${dto.id}">삭제</a>
						</c:if>
					</div>
				</div>


		<!-- 댓글 영역 -->
		<div class="comment">
			<div class="dat_add">
			<h4 class="tit">한줄 의견을 나눠 보세요</h4>
			<div>

				<form action="${rootPath}/comment/insert" method="post">
					<input type="hidden" name="id" id="id"  value="${sid}">
					<input type="hidden" name="par" id="par" value="${dto.freeNo}">

					<img src="${rootPath}/resource/image/sub/face.png" alt="" style="width: 70px; height: 70px; margin: 5px;">
					<c:if test="${empty sid}">
						<textarea rows="5" cols="50" name="content" id="content" class="tet" maxlength="300" required placeholder="로그인 후 이용해주세요!" readonly></textarea>
					</c:if>

					<c:if test="${not empty sid}">
					<textarea rows="5" cols="50" name="content" id="content" class="tet" maxlength="300" required placeholder="이곳에 댓글을 입력해주세요!"></textarea>
					<input type="submit" class="btn is-primary" value="등록">
					</c:if>
				</form>

			</div>
			</div>
			<div class="dat_list">
				<ul>
				<c:forEach var="comment" items="${commentList }">
					<li style="list-style: none; width: 100%; position: relative;">
						<div class="dat_box">
							<div class="dat_img">
								<p>${comment.id}</p>
							</div>
							<div class="dat_con">
							<div id="con">${comment.content}</div><br>
							<p id="reg">
								<fmt:parseDate value="${comment.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
							</p>
							</div>
							<c:if test="${sid eq comment.id || sid eq 'admin'}">
								<a class="btn is-primary" href="${rootPath}/comment/delete.do?dno=${comment.dno}&fno=${fno}">삭제</a>
							</c:if>
						</div>

					</li>
					</c:forEach>

				</ul>
				<c:if test="${empty commentList }">
					<tr>
						<td colspan="4">댓글이 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</div>
			<%--<tbody>
			<c:forEach items="${commentList }" var="board" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${comment.content }</td>
					<td>

					</td>
				</tr>
			</c:forEach>
			</tbody>--%>

			<!-- 여기까지 댓글 영역 -->

			</div>
			</div>
		</div>
	</section>
	</div>
</div>
</body>
</html>