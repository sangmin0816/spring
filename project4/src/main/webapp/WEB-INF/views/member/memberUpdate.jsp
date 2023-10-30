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

    <div class="row gutters-sm" style="margin-top: 2rem;">
        <div class="card text-black" style="border-radius: 25px;">
            <div class="card-body p-md-5">
                <div class="row justify-content-center">
                    <div class="col-12 col-md-8 order-2 order-lg-1">
                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Profile Edit</p>

                        <input type="hidden" name="oldPw" value="${member.pw}">
                        <form class="mx-1 mx-md-4" action="${rootPath}/member/memberUpdate" method="post">
                            <input type="hidden" id="pwck" value="no">
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="password" id="pw" name="pw" class="form-control" placeholder="새로운 비밀번호"/>
                                    <label for="pw" id="pwStatus" class="form-label">비밀번호를 입력하세요.</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="password" id="pw2" class="form-control" placeholder="Repeat your password"/>
                                </div>
                            </div>


                            <input type="hidden" name="membership" value="#{member.membership}">

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="text" id="name" name="name" class="form-control" value="${member.name}"/>
                                    <label for="name" class="form-label">Name</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="email" name="email" id="email" class="form-control" value="${member.email}"/>
                                    <label for="email" class="form-label">Email</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-phone fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="tel" name="tel" id="tel" class="form-control" value="${member.tel}"/>
                                    <label for="tel" class="form-label">전화번호</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="date" name="birth" id="birth" class="form-control" value="${member.birth}"/>
                                    <label for="birth" class="form-label">생일</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-map-marker-alt fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="text" name="addr1" id="addr1" class="form-control" style="margin-bottom: 10px;" value="${member.addr1}"/>
                                    <input type="text" name="addr2" id="addr2" class="form-control" value="${member.addr2}"/>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-hashtag fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <input type="text" name="postcode" id="postcode" class="form-control" style="margin-bottom: 10px;" value="${member.postcode}"/>
                                    <button type="button" class="btn btn-primary mt-10" onclick="findAddr()">Search ZIP code & Address</button>
                                </div>
                            </div>

                            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                <button type="submit" class="btn btn-primary btn-lg">수정하기</button>
                            </div>

                        </form>
                    </div>
                    <div class="col-12 col-md-4 d-flex align-items-center order-1 order-lg-2">
                        <img src="https://images.unsplash.com/photo-1597589827317-4c6d6e0a90bd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2080&q=80" alt="Profile Image" class="rounded-circle" width="150">
                        <input class="btn btn-success" type="file" value="${member.imageFile}">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%-- Profile Page Code Reference https://www.bootdey.com/snippets/view/profile-with-data-and-skills#html --%>