<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../../include/head.jsp" %>
    <style>
        a .answers {padding-left:30px;}
    </style>
</head>
<body>
<%@ include file="../../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-02">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">Qna</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="section blog-wrap container">

        <form action="${rootPath}/board/qnaInsert" method="post">
            <table class="table">
                <tbody>
                <tr>
                    <th class="has-text-white has-text-centered"><label for="title">제목</label></th>
                    <td>
                        <input type="text" name="title" id="title" class="input" required>
                        <input type="hidden" name="lev" id="lev" value="${lev}">
                        <input type="hidden" name="par" id="par" value="${par}">
                        <input type="hidden" name="author" id="author" value="${sid}">
                    </td>
                </tr>
                <tr>
                    <th class="has-text-white has-text-centered"><label for="content">내용</label></th>
                    <td>
                        <textarea name="content" id="content" cols="80" rows="10" maxlength="990" class="textarea"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="btns is-centered">
                <input type="submit" value="글 등록" class="btn is-mainColor">
                <a href="${rootPath}/board/qnaList" class="btn is-success">글 목록</a>
            </div>
        </form>
    </section>

</div>
</body>
</html>
