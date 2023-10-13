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
                    <div class="row">
                        <div class="col-sm-5"><h6 class="mb-0">예약 날짜</h6></div>
                        <div class="col-sm-7 text-secondary">${reservation.rdate}</div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-sm-5"><h6 class="mb-0">예약 시간</h6></div>
                        <div class="col-sm-7 text-secondary">${reservation.rtime}</div>
                    </div>
                    <hr>
                    <form action="${rootPath}/academy/academyReservationUpdateStatus">
                        <div class="row">
                            <div class="col-sm-5"><h6 class="mb-0">예약 상태</h6></div>
                            <div class="col-sm-7 text-secondary">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="pending" value="pending">
                                    <label class="form-check-label" for="pending">보류</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="approve" value="approve">
                                    <label class="form-check-label" for="approve">승인</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="refusal" value="refusal" >
                                    <label class="form-check-label" for="refusal">거절</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <input type="hidden" name="rno" value="${reservation.rno}">
                                <button class="btn btn-info" type="submit">상태변경</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <div class="col-md-8">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-3"><h6 class="mb-0">ID</h6></div>
                        <div class="col-sm-9 text-secondary">${member.id}</div>
                    </div>
                    <hr>
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
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    $(document).ready(function (){
        let state = "${reservation.status}";
        console.log(state);
        $("#"+state).attr("checked", true);
    });
</script>