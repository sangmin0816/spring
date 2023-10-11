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
    <%@include file="../include/head.jsp"%>
    <style>
        body .container .btn {
            margin: 10px;
            display: block;
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <h4>ajax</h4>
    <ul>
        <li><a href="${rootPath}/ajax/test1Pro">01_Get 전송</a></li>
        <li><a href="${rootPath}/ajax/test2">02_Post 전송</a></li>
        <li><a href="${rootPath}/ajax/test3">03_Get + Parameter 전송</a></li>
        <li><a href="${rootPath}/ajax/test4">04_Post + Parameter 전송</a></li>
    </ul>
    <div class="alert alert-primary" id="ajaxResult">AJAX</div>
    <button type="button" class="btn btn-danger" id="delete">Delete</button>

    <button type="button" class="btn btn-primary" id="btn1">01_Get 전송</button>
    <button type="button" class="btn btn-primary" id="btn2">02_Post 전송</button>

    <button type="button" class="btn btn-primary" id="btn5" age="5" name="kim">05_Get + @ModelAttribute + Object 전송</button>
    <button type="button" class="btn btn-primary" id="btn6" age="6" name="kim">06_Post + @ModelAttribute + Object 전송</button>
    <button type="button" class="btn btn-primary" id="btn7" age="7" name="kim">07_Post + @RequestBody + Object 전송</button>

    <button type="button" class="btn btn-primary" id="btn8" age="8" name="kim">08_Post + Parameter + List 전송</button>

    <button type="button" class="btn btn-primary" id="btn9" age="9" name="kim">09_Post + Parameter + ResponseEntity Object 전송</button>
    <button type="button" class="btn btn-primary" id="btn10" age="10" name="kim">10_Post + Parameter + ResponseEntity List 전송</button>

</div>
</body>
</html>

<script>
    $(document).ready(function(){
        $("#delete").click(function(){
            $("#ajaxResult").text("AJAX");
        })

        $("#btn1").click(function(){
            $.ajax({
                type: "get",
                url: "${rootPath}/ajax/test1pro?msg=데이터전송",
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text(res);
                },
                error: function(res){
                    console.log("실패", res);
                }
            })
        })

        $("#btn2").click(function(){
            $.ajax({
                type: "post",
                url: "${rootPath}/ajax/test2pro?msg=데이터전송",
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text(res);
                },
                error: function(res){
                    console.log("실패", res);
                }
            })
        })

        $("#btn5").click(function(){
            var human = {"age": parseInt($(this).attr("age")), "name": $(this).attr("name")};
            $.ajax({
                type: "get",
                url: "${rootPath}/ajax/test5pro",
                data: human,
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text("age: "+res.age+", name: "+res.name);
                },
                error: function(res){console.log("실패", res)},
            })
        })

        $("#btn6").click(function(){
            var human = {"age": parseInt($(this).attr("age")), "name": $(this).attr("name")};
            $.ajax({
                type: "post",
                url: "${rootPath}/ajax/test6pro",
                data: human,
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text("age: "+res.age+", name: "+res.name);
                },
                error: function(res){console.log("실패", res)},
            })
        })

        $("#btn7").click(function(){
            var human = {"age": parseInt($(this).attr("age")), "name": $(this).attr("name")};
            $.ajax({
                type: "post",
                url: "${rootPath}/ajax/test7pro",
                data: JSON.stringify(human),
                dataType: "json",
                contentType: "application/json",
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text("age: "+res.age+", name: "+res.name);
                },
                error: function(res){console.log("실패", res)},
            })
        })

        $("#btn8").click(function(){
            var human = {"age": parseInt($(this).attr("age")), "name": $(this).attr("name")};
            $.ajax({
                type: "post",
                url: "${rootPath}/ajax/test8pro",
                data: JSON.stringify(human),
                dataType: "json",
                contentType: "application/json",
                success: function(res){
                    console.log("성공", res);
                    $("#ajaxResult").text("age: "+res.age+", name: "+res.name);
                },
                error: function(res){console.log("실패", res)},
            })
        })
    })
</script>