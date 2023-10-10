<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::오시는길</title>
    <%@ include file="../include/head.jsp" %>

    <script type="text/javascript" src="http://dmaps.daum.net/map_js_init/v3.js"></script>
    <script type="text/javascript" src="http://s1.daumcdn.net/svc/original/U03/cssjs/jquery/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://s1.daumcdn.net/svc/original/U0301/cssjs/JSON-js/fc535e9cc8/json2.min.js"></script>
</head>

<body>
<%@ include file="../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-01">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">오시는 길</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="section blog-wrap container">
        <div class="wrap web guide" data-page_section="web" data-page_type="guide" data-title="Daum 지도 Web API 가이드">
                <div class="page_wrap">
                    <div class="maparea" style="display: flex; justify-content: center;">
                        <div id="map" style="width:1200px;height:600px; position:relative; margin: 50px auto; background:white; overflow:hidden;"></div>

                        <script>
                            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                                mapOption = {
                                    center: new daum.maps.LatLng(37.4786713,126.8864968), // 지도의 중심좌표
                                    level: 2 // 지도의 확대 레벨
                                };
                            var map = new daum.maps.Map(mapContainer, mapOption);
                            // 마커가 표시될 위치입니다
                            var markerPosition  = new daum.maps.LatLng(37.4786713,126.8864968);
                            // 마커를 생성합니다
                            var marker = new daum.maps.Marker({
                                position: markerPosition
                            });
                            // 마커가 지도 위에 표시되도록 설정합니다
                            marker.setMap(map);

                            var iwContent = '<div style="padding:5px;">마리오아울렛2관<br><a href="" style="color:blue;" target="_blank"></a></div>',
                                // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                iwPosition = new daum.maps.LatLng(37.4786713,126.8864968); //인포윈도우 표시 위치입니다
                            // 인포윈도우를 생성합니다
                            var infowindow = new daum.maps.InfoWindow({
                                position : iwPosition,
                                content : iwContent
                            });
                            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
                            infowindow.open(map, marker);
                        </script>

                        <script type="text/javascript" src="http://m1.daumcdn.net/tiara/js/td.min.js"></script>

                        <script type="text/javascript">
                            var _tiq = 'undefined' !== typeof _tiq ? _tiq : [];
                            window._tiq = _tiq;
                            _tiq.push(['__trackPageview']);
                        </script>

                        <script type="text/javascript" src="http://s1.daumcdn.net/svc/attach/U03/cssjs/mapapidoc/1421136453605/service.min.js"></script>

                    </div>
                    <div style="white-space: pre-line; font-size: 20px; margin: 0;">
                        <p style="font-size: 30px; font-weight: bolder; margin: 0;">마리오아울렛 2관 오시는 길</p>
                        <p style="font-size: 25px; font-weight: bold; margin: 0;"><i class="icofont-train-line"></i>지하철 이용하실 경우</p>
                        - 1, 7호선 : 가산디지털단지(마리오아울렛)역 4번 출구 역방향 직진 300m 도보3분

                        <p style="font-size: 25px; font-weight: bold; margin: 0;"><i class="icofont-bus-alt-1"></i>버스 이용하실 경우</p>
                        - 간선버스 : 503, 504, 571, 652
                        - 지선버스 : 5536, 5714, 5616, 5712
                        - 마을버스 : 금천07
                        - 공항버스 : 6004
                    </div>
                </div>
        </div>

    </section>


</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
