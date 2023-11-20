<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>HEABEOP::</title>
    <%@include file="../include/head.jsp"%>
    <style>
        .row {margin-bottom: 1rem;}
    </style>
</head>

<body>
<%@include file="../include/header.jsp"%>

<div class="content container">
    <div class="d-flex justify-content-center"><h2>상품 결제</h2></div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb justify-content-end">
            <li class="breadcrumb-item"><a href="${rootPath}">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">상품 결제</li>
        </ol>
    </nav>

    <div class="container contents">
        <div class="container">
            <div class="box_wrap">
                <form id="payForm" action="${rootPath}/payment/payinsert.do" method="post" class="form_row" onsubmit="return payCheck(this)">

                    <%-- 상품 정보 --%>
                    <table class="table text-center">
                        <thead>
                            <tr>
                                <th class="can1" >강의 이름</th>
                                <th class="can2" >선생님</th>
                                <th class="can3" >강의 가격</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <input type="hidden" name="courseNo" id="courseNo" value="${lecture.course.courseNo}">
                                <td class="can1" > ${lecture.course.title}</td>
                                <td class="can2"  >${lecture.teacher.name}</td>
                                <td class="can3"><a class="product_price">${lecture.course.price}</a>원</td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2" class="text-center" style="font-weight: bold; font-size: 20px"> 총 계 </td>
                                <td>
                                    <input type="number" name="total" id="total" readonly style="border: none; text-align: center; font-weight: bold;"/>원
                                </td>
                            </tr>
                        </tfoot>
                    </table>

                    <h3>배송 정보</h3>
                    <div class="row">
                        <div class="col-2"><label for="name" class="form-label">수신인 이름</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="name" name="name" required></div>
                        <div class="col-2"><label for="tel" class="form-label">수신인 전화번호</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="tel" name="tel" required></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="addr1" class="form-label">배송 주소</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="addr1" name="addr1" required></div>
                        <div class="col-4"><input type="text" class="form-control" id="postcode" name="postcode" placeholder="우편번호" required></div>
                        <div class="col-2"><button type="button" class="btn btn-primary mb-3" onclick="findAddr()">우편번호 검색</button></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="addr2" class="form-label">상세 주소</label></div>
                        <div class="col-8"><input type="text" class="form-control" id="addr2" name="addr2" required></div>
                        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                    </div>

                    <hr>
                    <h3>결제 정보</h3>
                    <div class="row">
                        <div class="col-2"><label for="pmethod" class="form-label">결제 수단</label></div>
                        <div class="col-4">
                            <select name="pmethod" id="pmethod" class="form-select">
                                <option value="신용카드">신용카드</option>
                                <option value="체크카드">체크카드</option>
                                <option value="계좌이체">계좌이체</option>
                            </select>
                        </div>
                        <div class="col-2"><label for="pcom" class="form-label">결제 회사</label></div>
                        <div class="col-4">
                            <select name="pcom" id="pcom" class="form-select">
                                <option value="선택안함">선택안함</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="paccount" class="form-label">결제 번호</label></div>
                        <div class="col-6"><input type="text" class="form-control" id="paccount" name="paccount" required></div>
                        <div class="col-2">
                            <input type="button" id="paybtn" value="결제하기" class="btn btn-primary">
                        </div>
                    </div>

                    <%--  일단은 pay했다고 치기  --%>
                    <input type="hidden" name="payCk" id="payCk" value="yes">
                    <input type="submit" id="buy" value="구매" class="btn btn-primary">
                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>


<script>
    $(document).ready(function(){
        let total = 0;
        $(".product_price").each(function(){
            total = total + parseInt($(this).text());
        })
        $("#total").val(total);
    })
</script>


<%-- 결제 수단 별 결제 회사 변경 --%>
<script>
    $(document).ready(function(){
        var credit_card = ["현대카드","농협카드","BC카드","KB카드"];
        var check_card = ["하나카드","농협카드","BC카드"];
        var bankArr = ["카카오뱅크","농협은행","신한은행","기업은행","국민은행"];
        $("#pmethod").change(function(){
            $("#pcom").html("<option value='선택안함'>선택안함</option>");
            var th = $(this).val();
            if(th==="신용카드"){
                for(var i=0;i<credit_card.length;i++) {
                    $("#pcom").append("<option value='" + credit_card[i] + "'>" + credit_card[i] + "</option>");
                }
            } else if(th==="체크카드"){
                for(var i=0;i<check_card.length;i++) {
                    $("#pcom").append("<option value='"+check_card[i]+"'>"+check_card[i]+"</option>");
                }
            } else {
                for(var i=0;i<bankArr.length;i++) {
                    $("#pcom").append("<option value='"+bankArr[i]+"'>"+bankArr[i]+"</option>");
                }
            }
        }).change();
    });
</script>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //주소 연동 API
    function findAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                var jibunAddr = data.jibunAddress;
                document.getElementById("postcode").value = data.zonecode;
                if(roadAddr !== '') {
                    document.getElementById("addr1").value = roadAddr;
                } else if(jibunAddr !== ''){
                    document.getElementById("addr1").value = jibunAddr;
                }
                document.getElementById("addr2").focus();
            }
        }).open();
    }
</script>


<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
    $(document).ready(function(){
        $("#paybtn").click(function(){
        IMP.init('imp67615784'); // 결제 API를 사용하기 위한 코드 입력!
        IMP.request_pay({
            pg : 'T5102001',
            pay_method : 'card',
            merchant_uid: "order_no_0001", //상점에서 생성한 고유 주문번호
            name : "${lecture.course.title}",
            amount : 0,
            buyer_email : 'iamport@siot.do',
            buyer_name : '${mem.name}',
            buyer_tel : '${mem.tel}',
            buyer_addr : '${mem.addr1} ${mem.addr2}',
            buyer_postcode : '${mem.postcode}'
        }, function(rsp) {
            if ( rsp.success ) {
                let form = document.getElementById("payForm");
                form.submit();
                alert("결제되었습니다.");
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                alert(msg);
            }
        });
        })})
</script>