<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HaeBeop</title>
    <%@include file="./WEB-INF/views/include/head.jsp"%>
</head>
<body>
<%@include file="./WEB-INF/views/include/header.jsp"%>

<div class="container">
    <h1>Index Page</h1>
    <h4>유효성 검사</h4>
    <ul>
        <%--        <li><a href=""></a></li>--%>
        <li><a href="${rootPath}/check/check1">check1</a></li>
        <li><a href="${rootPath}/check/check2">check2</a></li>
        <li><a href="${rootPath}/check/check3">check3</a></li>
        <li><a href="${rootPath}/check/check4">check4</a></li>
        <li><a href="${rootPath}/check/check5">check5</a></li>
        <li><a href="${rootPath}/check/check6">check6</a></li>
    </ul>

    <h4>json</h4>
    <ul>
        <li><a href="${rootPath}/json/get/1">Get Test1</a></li>
        <li><a href="${rootPath}/json/insert">Insert Test</a></li>
    </ul>

    <h4><a href="${rootPath}/ajax/">ajax</a></h4>
</div>

</body>
</html>