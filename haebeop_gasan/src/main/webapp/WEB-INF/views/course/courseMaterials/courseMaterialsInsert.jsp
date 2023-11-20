<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="sid" value='<%=session.getAttribute("sid")%>'/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../../include/head.jsp" %>
    <script type="text/javascript" src="${rootPath}/resource/ckeditor/ckeditor.js"></script>
</head>
<body>
<%@ include file="../../include/header.jsp" %>

<div class="container mt-3">
    <jsp:include page="../courseSidebar.jsp">
        <jsp:param name="courseNo" value="${courseNo}"/>
    </jsp:include>


    <div class="row gutters-sm" style="margin-top: 2rem; justify-content: space-around;">
        <section class="section blog-wrap container">
        <form action="${rootPath }/courseMaterials/courseMaterialsInsert" method="post" enctype="multipart/form-data">
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
                            CKEDITOR.replace('contents', {filebrowserUploadUrl: '${rootPath}/util/imageUpload'});
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
            <div class="is-centered">
                <input type="hidden" name="courseNo" value="${courseNo}">
                <input class="btn is-mainColor" type="submit" value="작성하기">
                <a href="${rootPath}/courseMaterials/courseMaterialsList?courseNo=${courseNo}" class="btn btn-success">글 목록</a>
            </div>
        </form>

    </section>
    </div>
</div>

</body>
</html>
