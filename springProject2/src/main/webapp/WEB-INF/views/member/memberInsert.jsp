<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- /web/member/login.jsp -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보수정</title>
    <%@ include file="../include/head.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<section class="page-title bg-02">
    <div class="container">
        <div class="columns">
            <div class="column is-12">
                <div class="block has-text-centered">
                    <h1 class="is-capitalize text-lg font-happy">회원가입</h1>
                </div>
            </div>
        </div>
    </div>
</section>
<br>
<br>
<br>
<div class="content container">
    <form class="text-left clearfix form_row" action="${rootPath}/member/insert" method="post" onsubmit="return inform(this)">
        <div class="columns GRADE">
            <input type="hidden" class="input" id="grade" name="grade" value="${grade}" >
            <div class="column is-1">회원유형</div>
            <c:choose>
                <c:when test="${grade eq 1}">
                    <div class="column is-6"><strong>학부모</strong></div>
                </c:when>
                <c:otherwise>
                    <div class="column is-6"><strong>학생</strong></div>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="columns ID">
            <input type="hidden" id="idck" value="no">
            <div class="column is-1"><label for="id">아이디</label></div>
            <div class="column is-6"><input type="text" class="input" id="id" name="id" aria-describedby="idStatus" pattern="^[A-Za-z0-9]{4,16}" maxlength="16" placeholder="아이디는 영문 또는 숫자 4글자 이상, 16글자 이하"></div>
            <div class="column"><button type="button" class="button button-primary mb-3" onclick="idcheck()">중복검사</button></div>
            <div class="column is-3" id="idStatus">아이디 중복 검사를 진행해주세요</div>
        </div>

        <div class="columns PASSWORD">
            <input type="hidden" id="pwck" value="no">
            <div class="column is-1"><label for="pw">비밀번호</label></div>
            <div class="column is-4"><input type="password" class="input" id="pw" name="pw" required pattern="^[A-Za-z0-9]{4}" placeholder="비밀번호는 영문 또는 숫자 4글자 이상"></div>
            <div class="column is-4"><input type="password" class="input" id="pwchk" name="pwchk" placeholder="비밀번호 확인해주세요" required></div>
            <div class="column" id="pwStatus"><strong style='color: red'>비밀번호를 입력하세요.</strong></div>
        </div>

        <div class="columns NAME">
            <div class="column is-1"><label for="name">이름</label></div>
            <div class="column"><input type="text" class="input" id="name" name="name" placeholder="이름을 입력하세요"></div>
            <div class="column is-1"><label for="birth">생일</label></div>
            <div class="column"><input type="date" class="input" id="birth" name="birth" placeholder="생일을 입력하세요"></div>
        </div>

        <div class="columns EMAIL&TEL">
            <div class="column is-1"><label for="email">이메일</label></div>
            <div class="column"><input type="email" class="input" id="email" name="email" placeholder="이메일을 입력하세요"></div>
            <div class="column is-1"><label for="tel">전화번호</label></div>
            <div class="column"><input type="tel" class="input" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="010-0000-0000 형식"></div>
        </div>

        <div class="columns ADDRESS1">
            <div class="column is-1"><label for="addr1">주소</label></div>
            <div class="column"><input type="text" class="input" id="addr1" name="addr1" placeholder="주소를 입력하세요."></div>
            <div class="column"><input type="text" class="input mt-10" id="postcode" name="postcode" placeholder="우편번호"></div>
            <div class="column"><button type="button" class="button button-primary  mt-10" onclick="findAddr()">우편번호 검색</button></div>
        </div>

        <div class="columns ADDRESS2">
            <div class="column is-1"><label for="addr2">상세주소</label></div>
            <div class="column"><input type="text" class="input" id="addr2" name="addr2" placeholder="상세주소를 입력하세요."></div>
        </div>


        <button type="submit" class="button text-center">회원가입</button>

    </form>
</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<script>
    $(document).ready(function(){
        $("#pwchk").keyup(function(){
            if($("#pw").val()===""||$("#pwchk").val()===""){
                console.log($("#pwchk").val())
                $("#pwStatus").html("<strong style='color: red'>비밀번호를 입력하세요.</strong>");
                $("#pwck").val("no");
            }
            else if($("#pw").val()==$("#pwchk").val()){
                $("#pwStatus").html("<strong style='color: green'>비밀번호가 일치합니다.</strong>");
                $("#pwck").val("yes");
            } else{
                $("#pwStatus").text("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
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

<%@ include file="../include/footer.jsp"%>
</body>
</html>