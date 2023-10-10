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
	<title>자유 게시판 글쓰기</title>
	<!-- 헤드 부분 인클루드 -->
    <jsp:include page="../include/head.jsp"></jsp:include>
	<!-- <script src="https://cdn.ckeditor.com/4.20.0/standard/ckeditor.js"></script> -->
	<script type="text/javascript" src="${path }/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<!-- 헤더 부분 인클루드 -->
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


	<div class="content" id="contents">
	    <div class="row column text-center">

	      <div class="container">
	      	<form action="${path }/board/free/insert.do" method="post">
			      <table id="table1" class="table">
			      	<tbody>
			      		<tr>
			      			<th class="has-text-white has-text-centered">글 제목</th>
			      			<td>
			      				<input type="text" name="title" id="title" class="input" placeholder="제목 입력" maxlength="98" required>
			      			</td>
			      		</tr>
			      		<tr>
			      			<th class="has-text-white has-text-centered">글 내용</th>
			      			<td>
			      				<textarea name="content" id="content" class="textarea" placeholder="내용 입력" rows="8" cols="100" maxlength="1400" required></textarea>
			      				<script>
			      				CKEDITOR.replace('content',	{filebrowserUploadUrl:'${path}/util/imageUpload.do'});
			      				</script>
			      			</td>
			      		</tr>
			      	</tbody>
			      </table>

					<div class="buttons is-centered">
						<input type="submit" class="submit button is-mainColor" value="글 등록" >
						<a class="button is-success" href="${path }/board/free/list.do">글 목록</a>
					</div>
			   </form>
	      </div>
	    </div>
	</div>
	<!-- 푸터 부분 인클루드 -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</div>
</body>
</html>