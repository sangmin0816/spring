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

<div style="background-color: #eee;">
    <div class="d-flex justify-content-center align-items-center h-100" style="padding: 20px 0px;">
        <div class="col-lg-12 col-xl-11">
            <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                            <form class="mx-1 mx-md-4" action="${rootPath}/member/memberInsert" method="post">

                                <input type="hidden" id="idck" value="no">
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-id-card fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input type="text" id="id" name="id" class="form-control" placeholder="ID"/>
                                        <label for="id" id="idStatus" class="form-label">아이디 중복 검사를 진행해주세요</label>
                                    </div>
                                    <button type="button" class="btn btn-primary ms-3" onclick="idcheck()">중복검사</button>
                                </div>

                                <input type="hidden" id="pwck" value="no">
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input type="password" id="pw" name="pw" class="form-control" placeholder="Password"/>
                                        <label for="pw" id="pwStatus" class="form-label">비밀번호를 입력하세요.</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input type="password" id="pw2" class="form-control" placeholder="Repeat your password"/>
                                    </div>
                                </div>


                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-graduation-cap fa-lg me-3 fa-fw"></i>
                                    <div class="form-check col">
                                        <input class="form-check-input" type="radio" name="membership" id="flexRadioDefault3" value="student" checked>
                                        <label class="form-check-label" for="flexRadioDefault3">
                                            학생
                                        </label>
                                    </div>
                                    <div class="form-check col">
                                        <input class="form-check-input" type="radio" name="membership" id="teacher" value="teacherU">
                                        <label class="form-check-label" for="teacher">
                                            선생님
                                        </label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input type="text" id="name" name="name" class="form-control" placeholder="Name"/>
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
                                        <input type="date" name="birth" id="birth" class="form-control" placeholder="Birth"/>
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


                                <div class="form-check d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" required/>
                                    <label class="form-check-label" for="form2Example3c">
                                        I agree all statements in <a href="#!">Terms of service</a>
                                    </label>
                                </div>

                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                </div>

                            </form>
                        </div>
                        <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" class="img-fluid" alt="Sample image">
                        </div>
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
        $("#pw2").keyup(function(){
            if($("#pw").val()===""||$("#pw2").val()===""){
                $("#pwStatus").html("<strong style='color: red'>비밀번호를 입력하세요.</strong>");
                $("#pwck").val("no");
            }
            else if($("#pw").val()==$("#pw2").val()){
                $("#pwStatus").html("<strong style='color: green'>비밀번호가 일치합니다.</strong>");
                $("#pwck").val("yes");
            } else{
                $("#pwStatus").html("<strong style='color: red'>비밀번호와 비밀번호 확인이 일치하지 않습니다.</strong>");
                $("#pwck").val("no");
            }
        })

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