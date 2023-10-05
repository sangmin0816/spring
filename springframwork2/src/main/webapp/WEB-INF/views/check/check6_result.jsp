<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>hibernate Result</title>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<h2>check6 결과</h2>
<hr>
<p>id : ${chk.id}</p>
<p>pw : ${chk.pw}</p>
</body>
</html>
