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
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex flex-column align-items-center text-center">
                        <img src="https://images.unsplash.com/photo-1597589827317-4c6d6e0a90bd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2080&q=80" alt="Profile Image" class="rounded-circle" width="150">
                        <div class="mt-3">
                            <h4>${member.id}</h4>
                            <p class="text-secondary mb-1">Full Stack Developer</p>
                            <p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<%--        소개란 --%>
        <div class="col-md-8">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">Name</h6></div>
                        <div class="col-sm-9 text-secondary">${member.name}</div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">Email</h6></div>
                        <div class="col-sm-9 text-secondary">${member.email}</div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">Tel</h6></div>
                        <div class="col-sm-9 text-secondary">${member.tel}</div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">Address</h6></div>
                        <div class="col-sm-9 text-secondary">${member.addr1} ${member.addr2} (${member.postcode})</div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">Birth</h6></div>
                        <div class="col-sm-9 text-secondary">${member.birth}</div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-sm-12">
                            <a class="btn btn-info" href="${rootPath}/member/update" style="float: right">Edit</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%-- Profile Page Code Reference https://www.bootdey.com/snippets/view/profile-with-data-and-skills#html --%>