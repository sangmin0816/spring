<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>해법</title>
    <%@ include file="../include/head.jsp" %>
    <style>
        #map {
            width: 500px; height: 500px;
            box-sizing: border-box;
            position:relative; background:white; overflow:hidden;
        }
    </style>
    <script src="${rootPath}/resources/js/jquery-1.11.0.js"></script>
    <script src="${rootPath}/resources/js/v3.js"></script>
    <script src="${rootPath}/resources/js/json2.min.js"></script>

<%--    <script src="${rootPath}/resources/js/td.min.js"></script>--%>
    <script src="${rootPath}/resources/js/service.min.js"></script>

    <script src="${rootPath}/resources/js/sidogungu.js"></script>
</head>

<body>
    <%@ include file="../include/header.jsp" %>
    <div class="container mt-3">

        <%--  검색 --%>
        <jsp:include page="../include/searchMap.jsp">
            <jsp:param name="formLink" value="${rootPath }/reservation/academyMapList" />
        </jsp:include>


        <div class="d-flex">
            <%--  지도  --%>
            <div class="col-7 me-3 maparea">
                <div class="container" id="map" style=""></div>
            </div>

            <%--  학원 목록  --%>
            <div class="col me-3" style="overflow-y: auto; max-height: 500px;">
                <ul class="list-group mb-3">
                    <c:forEach var="academy" items="${academyList}">
                        <li class="list-group-item">
                            <h5 class="card-title">${academy.name}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${academy.address}</h6>
                            <h6 class="card-subtitle mb-2 text-body-secondary">TEL. ${academy.tel}</h6>
                            <div class="d-flex justify-content-end"><a href="${rootPath}/reservation/calendar?ano=${academy.ano}" class="btn btn-primary">예약하기</a></div>
                        </li>
                    </c:forEach>
                    <c:if test="${empty academyList}">
                        <li class="list-group-item text-center" style="min-height: 100px;">목록을 불러올 수 없습니다.</li>
                    </c:if>
                </ul>

                <%--  페이지네이션 --%>
                <jsp:include page="../include/paginationMap.jsp">
                    <jsp:param name="formLink" value="${rootPath }/reservation/academyMapList" />
                </jsp:include>
            </div>
        </div>
    </div>
</body>

<script>
    var mapContainer = document.getElementById('map') // 지도를 표시할 div
    var mapOption = {
        center: new daum.maps.LatLng(37.4786713,126.8864968), // 지도의 중심좌표
        level: 6 // 지도의 확대 레벨
    };

    // 지도 생성
    var map = new daum.maps.Map(mapContainer, mapOption);

    // 마커가 표시될 위치입니다
    var markerPosition  = new daum.maps.LatLng(37.4786713,126.8864968);

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({
        position: markerPosition
    });


    marker.setMap(map);
    // 마커가 지도 위에 표시되도록 설정합니다

    // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    var iwContent = '<div style="padding:5px;">마리오아울렛2관<br><a href="" style="color:blue;" target="_blank"></a></div>'
    var iwPosition = new daum.maps.LatLng(37.4786713,126.8864968); //인포윈도우 표시 위치입니다
    // 인포윈도우를 생성합니다

    var infowindow = new daum.maps.InfoWindow({
        map:  map,
        position : iwPosition,
        content : iwContent
    });
    // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
    infowindow.open(map, marker);
</script>



<script type="text/javascript">
    var _tiq = 'undefined' !== typeof _tiq ? _tiq : [];
    window._tiq = _tiq;
    _tiq.push(['__trackPageview']);
</script>
</html>