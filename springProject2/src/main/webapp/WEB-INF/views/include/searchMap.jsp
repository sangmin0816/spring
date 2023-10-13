<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="formLink" value='<%=request.getParameter("formLink")%>'/>

<div class="d-flex justify-content-center">
    <form class="d-flex mb-3" role="search" action="${formLink}" method="get">
        <div class="input-group">
            <select class="form-select" name="sido" style="width: fit-content"></select>
            <select class="form-select" name="gugun" style="width: fit-content"></select>
            <input class="form-control" name="keyword" type="search" placeholder="가맹점 이름" aria-label="search" style="width: fit-content">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
    </form>
</div>