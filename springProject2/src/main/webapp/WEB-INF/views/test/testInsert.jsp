<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HaeBeop</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <c:set var="path" value="<%=pageContext.getServletContext().getContextPath()%>"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container">
    <form action="./json/insertModel" method="post" >
        <input type="text" name="title" id="title" placeholder="Title" required>
        <button id="insertBody" type="button">Insert BY @RequestBody</button>
        <button id="insertModel" type="button">Insert BY @ModelAttribute</button>
    </form>
</div>
</body>
</html>

<script>
    $(document).ready(function(){
        $("#insertBody").click(function(){
            var data = {"num": 0, "title": $("#title").val()};
            // 자바 일반 객체인 data
            $.ajax({
                type: "post",
                url: "${path}/json/insertBody",
                dataType: "json",
                data: JSON.stringify(data),
                // 일반 객체인 data를 json객체로 변환하여 보냄
                contentType: 'application/json',
                success: function(t){
                    console.log("insertBody 성공", t);
                    $("#title").val("");
                },
                error: function(e){
                    console.log("insertBody 실패", e);
                },
            })
        });

        $("#insertModel").click(function(){
            var data = {"num": 0, "title": $("#title").val()};
            $.ajax({
                type: "post",
                url: "${path}/json/insertModel",
                data: data,
                success: function(t){
                    console.log("insertModel 성공", t);
                    $("#title").val("");
                },
                error: function(e){
                    console.log("insertModel 실패", e);
                },
            })
        })
    })
</script>