<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<c:set var="headPath" value="${pageContext.request.contextPath }"/>

<footer id="ft">

    <div class="footer-wrap">
        <div class="footerV18">
            <span class="logo">티스푼</span>
            <div class="foot-cont company">
                <h2>티스푼</h2>
                <p>대표이사 : 최상민 / 서울시 금천구 가산로9길 54, 1004</p>
                <p>사업자등록번호 : 1004-00-8282 / 통신판매업 신고 : 제 10-1004호</p>
                <p>전화번호 : 1588-1004 / E-mail : tspoon@edu.co.kr</p>
                <p>개인정보보호책임자 : 황교진 / 소비자피해보상보험 SGI 서울보증</p>
                <p class="tPad15">호스팅서비스:㈜티스푼</p><br>
                <p class="copyright">COPYRIGHT © TSPOON ALL RIGHTS RESERVED.</p>
            </div>
            <div class="foot-side">
            <div class="foot-cont cs">
                <div class="foot-cscenter">
                        <p class="tit">고객센터</p>
                        <div class="open-time"><span>운영시간</span> <span class="time">오전 10시 ~ 오후 5시 (주말, 공휴일 휴무)</span></div>
                        <div class="open-time lunch"><span>점심시간</span> <span class="time">오후 11시 00분 ~ 오후 1시 00분</span></div>
                </div>
            </div>
            <div class="foot-sns">
                <a href="https://www.instagram.com/genia.academy/"><img src="http://fiximage.10x10.co.kr/web2021/cscenter/icon_sns_instagram.png" alt="insta"></a>
                <a href="#"><img src="http://fiximage.10x10.co.kr/web2021/cscenter/icon_sns_facebook.png" alt="facebook"></a>
                <a href="https://www.youtube.com/channel/UCgJ8iR8g3_7Cx-kqZZAcRrQ"><img src="http://fiximage.10x10.co.kr/web2021/cscenter/icon_sns_you.png" alt="yotube"></a>
            </div></div>

        </div>
    </div>


</footer>

<script>
    function loc(){
        var url = document.getElementById("sel").value;
        //location.href = url;  //현재 창에
        if(url!="") {
            var win = window.open(url); //새창에
        }
    }
</script>