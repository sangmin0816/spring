<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="sid" value='<%=session.getAttribute("sid")%>'/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼</title>
    <%@ include file="../include/head.jsp" %>
    <script type="text/javascript" src="${headPath }/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-04">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">학습 자료실</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="section blog-wrap container">
        <form action="${headPath }/board/dataBoardInsert.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="sid" id="sid" value="${sid}">
            <table class="table">
                <tbody>
                <tr>
                    <th class="has-text-centered has-text-white"><label for="title">제목</label></th>
                    <td><input type="text" class="input" name="title" id="title" placeholder="제목 입력"></td>
                </tr>
                <tr>
                    <th class="has-text-centered has-text-white"><label for="contents">내용</label></th>
                    <td>
                        <textarea name="contents" id="contents" class="textarea" placeholder="내용 입력" maxlength="1500"></textarea>
                        <script>
                            CKEDITOR.replace('contents', {filebrowserUploadUrl: '${headPath}/dataFile/upload.do'});
                        </script>
                    </td>
                </tr>
                <tr>
                    <th class="has-text-centered has-text-white"><label for="uploadFiles">파일 업로드(10MB 이하)</label></th>
                    <td>
                        <input class="input" type="file" name="uploadFiles" id="uploadFiles" multiple="true">
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="buttons is-centered">
                <input class="button is-mainColor" type="submit" value="작성하기">
                <a href="${headPath }/board/dataBoardList.do" class="button is-success">글 목록</a>
            </div>
        </form>

    </section>
</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
