<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HaeBeop</title>
    <%@include file="../include/head.jsp"%>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <%@include file="sidebar.jsp"%>

    <div class="row gutters-sm ms-3 mt-3">
        <div class="container">
            <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">학원 등록하기</p>
                    <form class="mx-1 mx-md-4" action="${rootPath}/academy/academyInsert" method="post">
                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-id-card fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="text" id="id" name="id" class="form-control" placeholder="관리자 ID"/>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="text" id="name" name="name" class="form-control" placeholder="학원 이름"/>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="email" name="email" id="email" class="form-control" placeholder="Email"/>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-phone fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="tel" name="tel" id="tel" class="form-control" placeholder="Telephone"/>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="time" id="opentime" name="opentime" class="form-control" value="13:00:00"/>
                                <label for="opentime" class="form-label">개점 시간</label>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="time" id="closetime" name="closetime" class="form-control" placeholder="22:00:00"/>
                                <label for="closetime" class="form-label">폐점 시간</label>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="number" id="capacity" name="capacity" class="form-control" value="2"/>
                                <label for="capacity" class="form-label">시간 당 최대 상담 가능 인원</label>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-map-marker-alt fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="text" name="addr1" id="addr1" class="form-control" style="margin-bottom: 10px;" placeholder="Address"/>
                                <input type="text" name="addr2" id="addr2" class="form-control" placeholder="Detailed Address"/>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-hashtag fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <input type="text" name="postcode" id="postcode" class="form-control" placeholder="postcode" style="margin-bottom: 10px;"/>
                                <button type="button" class="btn btn-primary mt-10" onclick="findAddr()">Search ZIP code & Address</button>
                            </div>
                        </div>

                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                            <button type="submit" class="btn btn-primary btn-lg">등록하기</button>
                        </div>
                    </form>

                </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
    $(document).ready(function(){
        $("#id").keyup(function(){
            $("#idck").val("no");
            $("#idStatus").text("아이디 중복 검사를 진행해주세요");
        })
    })

    function inform(frm){
        if($("#idck").val()!="yes"){
            alert("아이디 중복 검사를 진행하지 않았습니다.")
            $("#id").focus();
            return false;
        }
        if($("#pwck").val()!="yes"){
            alert("비밀번호를 다시 확인해주십시오.");
            $("#pw").focus();
            return false;
        }
    }

    function idcheck(){
        if($("#id").val()==""){
            alert("아이디를 입력하지 않았습니다.")
            $("#id").focus();
            return false;
        }
        var params = {id:$("#id").val()}
        $.ajax({
            url:"${rootPath}/member/idcheck",
            type: "POST",
            dataType: "json",
            data: params,
            success: function(data){
                var idPass = data.result;
                console.log(idPass);
                if(idPass===false){
                    $("#idck").val("no");
                    $("#idStatus").html("<strong style='color:red;'>사용할 수 없는 아이디 입니다.</strong>");
                    $("#id").focus();
                }
                else if(idPass){
                    $("#idck").val("yes");
                    $("#idStatus").html("<strong style='color:green;'>사용할 수 있는 아이디 입니다.</strong>");
                } else{
                    $("#idStatus").html("<strong style='color:red;'>아이디가 확인되지 않았습니다. 다시 시도하시길 바랍니다.</strong>");}
            }
        })
    }

    function findAddr(){
        new daum.Postcode({
            oncomplete:function(data){
                var roadAddr = data.roadAddress;
                var jibunAddr = data.jibunAddress;
                document.getElementById("postcode").value = data.zonecode;
                if(roadAddr !== ''){
                    document.getElementById("addr1").value = roadAddr;
                } else if(jibunAddr !== ''){
                    document.getElementById("addr1").value = jibunAddr;
                }
                document.getElementById("addr2").focus();
            }
        }).open();
    }
</script>