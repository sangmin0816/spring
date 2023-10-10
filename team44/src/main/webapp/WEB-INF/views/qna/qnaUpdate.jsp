<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼</title>
    <%@ include file="../include/head.jsp" %>
    <style>
        a .answers {padding-left:30px;}
    </style>
</head>

<body>
<%@ include file="../include/header.jsp" %>

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
        <form action="${headPath }/board/qnaUpdate.do" method="post">
            <table class="table" id="myTable">
                <thead>
                <tr>
                    <th class="has-text-white has-text-centered">유형</th>
                    <th class="has-text-white has-text-centered">글 제목</th>
                    <th class="has-text-white has-text-centered">작성자</th>
                    <th class="has-text-white has-text-centered">작성 일시</th>
                    <th class="has-text-white has-text-centered">조회수</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <c:if test="${qna.lev==0}">
                        <td>질문</td>
                    </c:if>
                    <c:if test="${qna.lev==1}">
                        <td>답변</td>
                    </c:if>
                    <td><input type="text" class="input" name="title" id="title" value="${qna.title}"></td>
                    <td>${qna.author}</td>
                    <td>
                        <fmt:parseDate value="${qna.regdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${resdate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td>${qna.visited}</td>
                </tr>
                <tr>
                    <td colspan="5">
                        <textarea name="content" id="content" cols="30" rows="10" class="textarea">${qna.content}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>

            <input type="hidden" name="qno" id="qno" value="${qna.qno}">

            <div class="buttons is-centered">
                <a href="${headPath }/board/qnaList.do" class="button is-mainColor">목록</a>
                <input type="submit" class="button is-success" value="수정 완료">
            </div>
        </form>
    </section>

</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='4' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>