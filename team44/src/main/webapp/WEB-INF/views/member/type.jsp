<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="headPath" value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원약관</title>
    <jsp:include page="./../include/head.jsp" />

    <style>
        .typ {
            list-style: none;
            width: 1500px;
            margin: 0 auto;
            height: 900px;
            clear:both;
            text-align: center;
        }

        .pic_type li {
            display: inline-block;
            padding: 10px;
            width: 600px;
            height: 400px;
            font-size: 24px;
        }

        .pic_type input {display:none;}
        .pic_type input + label {
            cursor: pointer;
            background-color: #f6f6f9;
        }
        .pic_type input:checked + label {
            font-weight: bold;
            background: cornflowerblue;
            color: white;
        }

        .btn_type {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            font-size: 30px;
            font-weight: bold;
            background-color: cornflowerblue;
            border: cornflowerblue;
            color: white;
        }
        .btn_type:hover {
            background-color: royalblue;
            border: royalblue;
            color: white;
        }

    </style>
</head>
<body>
<header class="hd" id="hd">
    <jsp:include page="./../include/header.jsp" />
    <link rel="stylesheet" href="${headPath}/resources/css/boardget.css">

</header>

<div class="content">

    <section class="page-title bg-02">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">회원 유형</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>

<form action="${headPath}/member/join.do" method="post" class="typ">
    <div>
        <ul class="pic_type">
            <li>
                <input type="radio" name="grade" value="1" id="par" checked>
                <label for="par"><img class="pic" src="${headPath }/resources/image/main/par1.png" alt="학부모">
                    <br>학부모</label><br>
            </li>
            <li>
                <input type="radio" name="grade" value="2" id="stu">
                <label for="stu"><img class="pic" src="${headPath }/resources/image/main/stu1.png" alt="학생">
                    <br>학생</label><br>
            </li>
        </ul>
    </div>
    <br>
    <br>
    <br>
    <input class="btn_type" type="submit" value="다음 단계">
</form>
    <jsp:include page="./../include/footer.jsp" />

</div>

</body>
</html>
