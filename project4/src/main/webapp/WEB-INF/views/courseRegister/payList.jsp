<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제내역</title>
    <%@ include file="../common.jsp"%>
    <style>
        a {margin: auto 5px;}
    </style>
</head>

<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">결제내역</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li><a href="${rootPath}/CartList.do">장바구니</a></li>
                            <li class="active">결제내역</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container contents">
        <div class="container">
            <div class="box_wrap">
                <form action="" method="post">
                <table class="table" id="tb1">
                    <thead>
                    <tr>
                        <th>결제 번호</th>
                        <th>상품 이름</th>
                        <th>상품 가격</th>
                        <th>상품 개수</th>
                        <th>결제 방법</th>
                        <th>배송 상태</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="payvo" items="${payvoList}">
                    <tr>
                        <td>${payvo.pay.payNo}</td>
                        <td>${payvo.pro.title}</td>
                        <td>${payvo.pay.payPrice}</td>
                        <td>${payvo.pay.amount}</td>
                        <td>${payvo.pay.method}</td>
                        <td class="del_state">${payvo.del.state}</td>
                        <td class="refund">${payvo.pay.payNo}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
        $(".del_state").each(function(){
            var payNo = $(this).next("td").text();
            console.log(payNo)
            if($(this).text()==="0"){
                $(this).text("배송 전");
                $(this).next("td").html("<a class='btn btn-primary' href='${rootPath}/Refund.do?payNo="+payNo+"'>결제취소</a>");
            } else if($(this).text()==="1"){
                $(this).text("배송 중");
                $(this).next("td").html("<a class='btn btn-primary' href='${rootPath}/Refund.do?payNo="+payNo+"'>반품 신청</a>");
            } else if($(this).text()==="2"){
                $(this).text("도착");
                $(this).next("td").html("<a class='btn btn-primary' href='${rootPath}/Refund.do?payNo="+payNo+"'>반품 신청</a><a class='btn btn-primary' href='${rootPath}/PayConfirm.do?payNo="+payNo+"'>구매 확정</a>");
            } else{
                $(this).text("구매 결정");
                $(this).next("td").text("");
            }
        })
    })
</script>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='7' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>