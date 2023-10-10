<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="headPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 마이페이지</title>
    <!-- 헤드 부분 인클루드 -->
    <jsp:include page="./../include/head.jsp" />
</head>
<body>
<div class="container is-fullhd">
    <!-- 헤더 부분 인클루드 -->
    <jsp:include page="./../include/header.jsp" />

    <div class="content" id="content">
        <div class="row column text-center">
            <div class="container">
                <h2 class="page_tit">마이 페이지</h2>
                <hr>
                <div class="tabs is-centered">
                    <ul>
                        <li class="is-active"><a>나의 정보</a></li>
                        <li><a href="${headPath }/vote/getMyList.do">나의 투표 내역</a></li>
                        <li><a href="${headPath }/attend/getMyAttend.do">나의 출석</a></li>
                    </ul>
                </div>
                <hr>
                <form action="${headPath }/member/update.do" method="post" onsubmit="return updateCheck(this)">
                    <div class="table_form_wrap">
                        <table class="table_form">
                            <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>${member.id } </td>
                                <input type="hidden" name="id" id="id">
                            </tr>
                            <tr>
                                <input type="hidden" name="oldPw" value="${member.pw}">
                                <th><label for="pw">비밀번호</label></th>
                                <td><input type="password" name="pw" id="pw" class="input" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" >
                                    <p>(최소 8자리에서 최대 16자리까지, 숫자, 영문 대소문자, 특수문자가 각 1 문자 이상 포함되어야 함)</p>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="pw2">비밀번호 확인</label></th>
                                <td><input type="password" name="pw2" id="pw2" class="input" >
                                </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>${member.name }</td>
                            </tr>
                            <tr>
                                <th><label for="email">이메일</label></th>
                                <td><input type="email" name="email" id="email" class="input" value="${member.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" ></td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td><input type="tel" class="input" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="010-0000-0000 형식" value="${member.tel }"></td>
                            </tr>
                            <tr>
                                <th><label for="findBtn" onclick="findAddr()">주소</label></th>
                                <td>
                                    <input type="text" name="addr1" id="addr1" class="input" value="${member.addr1 }"><br>
                                    <input type="text" name="addr2" id="addr2" class="input" value="${member.addr2 }"><br>
                                    <input type="text" name="postcode" id="postcode"  class="input" value="${member.postcode }">
                                    <input type="button" value="주소찾기" onclick="findAddr()" id="findBtn" class="btn is-primary">
                                </td>
                            </tr>
                            <tr>
                                <th>생년월일</th>
                                <td>
                                    <fmt:parseDate value="${member.birth }" var="birth" pattern="yyyy-MM-dd" />
                                    <input type="date" name="birth" value="${member.birth}">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" class="button btn-writer" value="회원정보수정">
                                    <input type="reset" class="button btn-primary" value="취소">

                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
                <script>
                    function updateCheck(f){
                        if(f.pw.value!=f.pw2.value){
                            alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
                            return false;
                        }
                    }
                </script>
                <script>
                    function findAddr() {
                        new daum.Postcode({
                            oncomplete: function(data) {
                                console.log(data);
                                var roadAddr = data.roadAddress;
                                var jibunAddr = data.jibunAddress;
                                document.getElementById("postcode").value = data.zonecode;
                                if(roadAddr !== '') {
                                    document.getElementById("addr1").value = roadAddr;
                                } else if(jibunAddr !== ''){
                                    document.getElementById("addr1").value = jibunAddr;
                                }
                            }
                        }).open();
                    }
                </script>
                <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            </div>
        </div>
    </div>

    <!-- 푸터 부분 인클루드 -->
    <footer class="ft" name="ft">
        <jsp:include page="./../include/footer.jsp" />
    </footer>
</div>
</body>
</html>