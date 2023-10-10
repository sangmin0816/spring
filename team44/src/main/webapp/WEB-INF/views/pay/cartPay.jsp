<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니 결제</title>
    <%@ include file="../common.jsp"%>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>

<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">장바구니 결제</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">장바구니 결제</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container contents">
        <div class="container">
            <div class="box_wrap">
                <form action="${rootPath }/PayCartPro.do" method="post" class="form_row" onsubmit="return payCheck(this)">
                <table class="table" id="tb1">
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>상품 이름</th>
                        <th>상품 가격</th>
                        <th>개수</th>
                        <th>총계</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cartVO" items="${cartVOList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>
                            <input type="checkbox" name="cartCheck" value="${cartVO.cart.cartNo}" hidden="true" checked>
                                ${cartVO.product.title}
                        </td>
                        <td>${cartVO.product.price}</td>
                        <td>${cartVO.cart.amount}</td>
                        <td class="product_price">${cartVO.product.price*cartVO.cart.amount}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2" class="text-center">총계</td>
                            <td colspan="3" id="total"></td>
                        </tr>
                    </tfoot>
                </table>

                    <h3>주문자 정보</h3>
                    <div class="row">
                        <div class="col-2"><label for="mem_name" class="form-label">이름</label></div>
                        <div class="col-8"><input type="text" class="form-control" id="mem_name" name="mem_name" readonly value="${mem.name}"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="email" class="form-label">이메일</label></div>
                        <div class="col-4"><input type="email" class="form-control" id="email" name="email" readonly value="${mem.email}"></div>
                        <div class="col-2"><label for="mem_tel" class="form-label">전화번호</label></div>
                        <div class="col-4"><input type="tel" class="form-control" id="mem_tel" name="mem_tel" readonly value="${mem.tel}"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="mem_address" class="form-label">주소</label></div>
                        <div class="col-6"><input type="text" class="form-control" id="mem_address" name="mem_address" readonly value="${mem.address}"></div>
                        <div class="col-4"><input type="text" class="form-control" id="mem_postcode" name="mem_postcode" readonly value="${mem.postcode}"></div>
                    </div>

                    <hr>
                    <h3>배송 정보</h3>
                    <%--  Delivery의 name, tel, address  --%>
                    <div class="row">
                        <div class="col-2"><label for="name" class="form-label">수신인 이름</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="name" name="name" required></div>
                        <div class="col-2"><label for="tel" class="form-label">수신인 전화번호</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="tel" name="tel" required></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="address1" class="form-label">배송 주소</label></div>
                        <div class="col-4"><input type="text" class="form-control" id="address1" name="address1" required></div>
                        <div class="col-4"><input type="text" class="form-control" id="postcode" name="postcode" placeholder="우편번호" required></div>
                        <div class="col-2"><button type="button" class="btn btn-primary mb-3" onclick="findAddr()">우편번호 검색</button></div>
                    </div>
                    <div class="row">
                        <div class="col-2"><label for="address2" class="form-label">상세 주소</label></div>
                        <div class="col-8"><input type="text" class="form-control" id="address2" name="address2" required></div>
                        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                    </div>

                    <hr>
                    <h3>결제 정보</h3>
                    <%--  Payment의 method, pcom, paccount --%>
                    <div class="row">
                        <div class="col-2"><label for="method" class="form-label">결제 수단</label></div>
                        <div class="col-4">
                            <select name="method" id="method" class="form-select">
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
                            <input type="button" id="pay" value="결제하기" class="btn btn-primary">
                        </div>
                    </div>
                    <%--  일단은 pay했다고 치기  --%>
                    <input type="hidden" name="payCk" id="payCk" value="yes">
                    <input type="submit" id="buy" value="구매" class="btn btn-primary">
                    <a href="${rootPath }/ProList.do" class="btn btn-primary">제품 목록</a>
                </form>

            </div>
        </div>
    </div>
    <%@ include file="../footer.jsp" %>
    <%@ include file="../commonsub.jsp" %>
</body>
</html>


<script>
    $(document).ready(function(){
        let total = 0;
        $(".product_price").each(function(){
            total = total + parseInt($(this).text());
        })
        $("#total").text(total+" 원");
    })
</script>


<%-- 결제 수단 별 결제 회사 변경 --%>
<script>
    $(document).ready(function(){
        var credit_card = ["현대카드","농협카드","BC카드","KB카드"];
        var check_card = ["하나카드","농협카드","BC카드"];
        var bankArr = ["카카오뱅크","농협은행","신한은행","기업은행","국민은행"];
        $("#method").change(function(){
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

<script>
    //주소 연동 API
    function findAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                console.log(data);
                var roadAddr = data.roadAddress;
                var jibunAddr = data.jibunAddress;
                document.getElementById("postcode").value = data.zonecode;
                if(roadAddr !== '') {
                    document.getElementById("address1").value = roadAddr;
                } else if(jibunAddr !== ''){
                    document.getElementById("address1").value = jibunAddr;
                }
                document.getElementById("address2").focus();
            }
        }).open();
    }
</script>

<script>
    //결제모듈 API 연동
    $(document).ready(function(){
        var totalPay=0;
        var proName;
        $("#pay").click(function(){
            var email = $("#mem_name").val();
            var cname = $("#mem_email").val();
            var tel = $("#mem_tel").val();
            var addr = $("#mem_address").val();
            var postcode = $("#mem_postcode").val();
            proName = ${cartVO.product.title};
            amount = ${cartVO.cart.amount}
                totalPay = parseInt($("#total").text());
            //상품명_현재시간
            var d = new Date();
            var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();
            IMP.init('imp31083748'); // 결제 API를 사용하기 위한 코드 입력!
            IMP.request_pay({		//결제 요청
                merchant_uid : '상품명_' + date, //상점 거래 ID
                name : proName,				// 결제 명
                amount : totalPay,					// 결제금액
                buyer_email : email, // 구매자 email
                buyer_name : cname,				// 구매자 이름
                buyer_tel : tel,		// 구매자 전화번호
                buyer_addr : addr,		// 구매자 주소
                buyer_postcode : postcode			// 구매자 우편번호
            }, function(rsp){
                if(rsp.success){
                    console.log(rsp);
                    var msg = '결제가 완료 되었습니다.';
                    var r1 = '고유 아이디 : ' +rsp.imp_uid;
                    var r2 = '상점 거래 아이디 : ' +rsp.merchant_uid;
                    var r3 = '결제 금액 : ' +rsp.paid_amount;
                    var r4 = '카드 승인 번호 : '+rsp.apply_num;

                    //$("#payCk").val("yes");
                    //$("#payAmount").val(rsp.paid_amount);
                    //$("#pmethod").val(rsp.pay_method);
                    //$("#pcom").val(rsp.pg_provider);
                    //$("#cnum").val(rsp.apply_num);
                    //alert(msg);
                    //$("#paymentResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
                } else{
                    //$("#paymentResult").html('결제실패<br>'+'에러내용 : ' +rsp.error_msg);
                }
                //테스트용이므로 실패시에도 그냥 통과시킴
                $("#payCk").val("yes");
                $("#payAmount").val(totalPay);
                $("#pmethod").val("신용카드");
                $("#pcom").val("삼성카드");
                $("#cnum").val("123-1234-1234-1278");
                $("#paymentResult").text("결제 완료 : "+totalPay);
            });
        });
    });
</script>
<script>
    function payCheck(f){
        var payCk = f.payCk.value;
        if(payCk!="yes"){
            alert("아직 결제 전 입니다.");
            return false;
            $("#pay").focus();
        }
    }
</script>