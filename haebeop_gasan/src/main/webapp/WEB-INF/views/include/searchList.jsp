<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="formLink" value='<%=request.getParameter("formLink")%>'/>

<div class="d-flex justify-content-end">
    <form class="d-flex mb-3" role="search" action="${formLink}" method="get" style="max-width: 40%;">
        <div class="input-group">
            <input class="form-control" type="search" placeholder="검색어를 입력하세요" aria-label="search" name="keyword" style="width: 50%;" required>
            <select class="form-select" id="type" name="type" style="width: 30%;" required>
                <option selected value=''>검색 옵션</option>
            </select>
            <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
    </form>
</div>

<c:set var="selectOptions" value='<%=request.getParameter("selectOptions")%>'/>

<script>
    var selectOptions = "${selectOptions}";
    var options = selectOptions.split(",");

    for(i in options){
        var option = options[i].split(":");
        var newoption = `<option value="\${option[0]}"<c:if test="${type eq '\${option[0]}' }"> selected</c:if>>\${option[1]}</option>`;
        $("#type").append(newoption);
    }
</script>