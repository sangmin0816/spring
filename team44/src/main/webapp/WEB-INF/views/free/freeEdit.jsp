<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글 수정하기</title>
    <!-- 헤드 부분 인클루드 -->
    <jsp:include page="../include/head.jsp"></jsp:include>
    <script type="text/javascript" src="${path }/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<header class="hd" id="hd">
	<jsp:include page="../include/header.jsp" />
</header>

<div class="content">

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
		<form action="${path }/board/free/update.do" method="post">
			<table id="table1" class="table">
				<tbody>
					<tr>
						<th class="has-text-white has-text-centered">글 제목</th>
						<td>
							<input type="hidden" name="fno" id="fno" value="${dto.fno }" >
							<input type="text" name="title" id="title" class="input" placeholder="제목 입력" value="${dto.title }" maxlength="98" required>
						</td>
					</tr>
					<tr>
						<th class="has-text-white has-text-centered">글 내용</th>
						<td>
							<textarea name="content" class="textarea" id="content" placeholder="내용 입력" rows="8" cols="100" maxlength="800" required>
								${dto.content }
							</textarea>
							<script>
								CKEDITOR.replace('content',	{filebrowserUploadUrl:'${path}/util/imageUpload.do'});
							</script>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="buttons is-centered">
				<a class="button is-mainColor" href="${path }/board/free/list.do">글 목록</a>
				<input type="submit" class="button is-success" value="수정 완료" >
			</div>
		</form>
	</section>
	<!-- 푸터 부분 인클루드 -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</div>
</body>
</html>