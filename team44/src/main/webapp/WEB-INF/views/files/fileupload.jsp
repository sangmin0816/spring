<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HaeBeop</title>
    <%@include file="../include/head.jsp"%>
    <style>
        .form-control input {margin: 10px auto;}
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">

    <form class="col s12 l6 offset-l3" action="" method="post" enctype="multipart/form-data">
        <div class="mb-3" id="fileContainer">
            <label class="form-label">첨부파일로 업로드 가능한 용량은 최대 50MB 입니다.</label>
            <input class="form-control" type="file" name="file">
        </div>
        <button type="button" class="btn" id="btnAddFile"><i class="fas fa-plus-circle" style="color: #458a00;"></i></button>

<%--        <button class="btn btn-primary" type="button" onclick="return submit1(this.form)">업로드1 MultipartRequest</button>--%>
        <div>
            <button class="btn btn-primary" type="button" onclick="return submit2(this.form)">업로드2 MultipartHttpServletRequest</button>
            <button class="btn btn-primary" type="button" onclick="return submit3(this.form)">업로드3 MultipartFile</button>
            <button class="btn btn-primary" type="button" onclick="return submit4(this.form)">업로드4 ResponseBody + MultipartFile</button>
        </div>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">FileName</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="file" items="${fileList}" varStatus="status">
            <td>${status.count}</td>
            <td>${file.fileName}</td>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


<script>
    let submit1 = function(form){
        form.action = "${rootPath}/files/fileupload1"
        form.submit();
        return true;
    }
    let submit2 = function(form){
        form.action = "${rootPath}/files/fileupload2"
        form.submit();
        return true;
    }
    let submit3 = function(form){
        form.action = "${rootPath}/files/fileupload3"
        form.submit();
        return true;
    }
    let submit4 = function(form){
        let formData = new FormData();
        formData.append('file', $('#file')[0].files);
        $.ajax({
            type : "POST",
            enctype : "multipart/form-data",
            url : "${rootPath}/files/fileupload4",
            cache : false,
            contentType : false,
            processData : false,
            data : formData,
            success : function(data){
                console.log(data);
            },
            error : function(){
                alert('에러');
            }
        });

        return true;
    }
</script>

<script>
    var fileContainer = document.querySelector('#fileContainer');

    var btnAddFile = document.querySelector('#btnAddFile');

    var fileCount = 1; // 첨부파일 선택상자 개수

    btnAddFile.addEventListener('click', function () {
        if (fileCount >= 5) {
            alert('첨부파일은 최대 5개까지만 업로드 가능합니다.')
            return;
        }
        fileCount++; // 추가된 첨부파일 선택상자 개수 반영

        var input = '<input class="form-control" type="file" name="file">';

        // fileContainer.innerHTML += input;
        fileContainer.insertAdjacentHTML("beforeend", input);
    });

</script>