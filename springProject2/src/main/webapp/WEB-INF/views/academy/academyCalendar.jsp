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
    <link rel="stylesheet" href="${rootPath}/resources/css/calendar.css">
    <style>
        td.unavailable {
            background-color: #f1ffd5;
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container">
    <%@include file="sidebar.jsp"%>

    <div class="row gutters-sm" style="margin-top: 2rem;">

        <div class="container">
            <h2>${yyyy}년 ${mm}월 달력</h2>
            <div class="d-flex">
                <div class="calendar me-3">
                    <table class="text-center">
                        <thead>
                        <tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${calList}" var="cal">
                            <tr>
                                <c:forEach items="${cal}" var="day">
                                    <td class="calendar-day" id="day${day}">
                                        <a href="javascript:selectDay(${day})"  >
                                            <div class="day"><div class="day-field">${day}</div></div>
                                            <div class="event">${event}</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="reservation">
                    <form id="calForm" action="${rootPath}/academy/insertUnavailable" method="post" onsubmit="return isSubmit(this)">
                        <input type="hidden" id="rdate" name="rdate">
                        <input type="hidden" name="ano" value="${ano}">
                        <div id="timebox" class="rtimes p-3 container justify-content-center text-center">
                            날짜를 선택해주세요.
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>

<script>
    let today = ${today};
    let restDays = ${restDayList};
    let unavailableDays = ${unavailableList};

/*    let isSubmit = function(form){
        var selectedRadio = form.querySelector('input[name="rtime"]:checked');

        if (!selectedRadio) {
            alert("시간대를 선택해주세요.");
            return false;
        }

        return true;
    };*/

    $(document).ready(function(){
        $("#day"+today).addClass("today");
        $("#day"+today).find(".event").text("TODAY");

        for (var [key, value] of Object.entries(unavailableDays)) {
            $("#day"+key).addClass("unavailable");
            $("#day"+key).find(".event").text(value);
        }

        for(var i=1; i<=parseInt(today); i++){
            $("#day"+i).addClass("pastdays");
            $("#day"+i).find("a").removeAttr("href");
        }

        for (var [key, value] of Object.entries(restDays)) {
            $("#day"+key).addClass("holiday");
            $("#day"+key).find(".event").text(value);
            $("#day"+key).find("a").removeAttr("href");
        }

    });

    let selectDay = function(day){
        $(".calendar-day").removeClass("selectDay");

        let rdate = "${yyyy}-${mm}-"+day;

        $("#rdate").val(rdate);
        $("#day"+day).addClass("selectDay");

        $("#timebox").html(`<p>\${day}일 휴일 설정하기</p>`);

        if($("#day"+day).hasClass("unavailable")){
            $("#calForm").attr("action", "${rootPath}/academy/deleteUnavailable");
            $("#timebox").append('<button class="btn btn-danger" type="submit">삭제하기</button>');
        }

        else{
            var time = `<div class="mb-3"><label for="reason" class="form-label">예약 불가 사유</label><input type="text" class="form-control" id="reason" name="reason" placeholder="사유를 입력하세요." required></div>`

            $("#timebox").append(time);
            $("#timebox").append('<button class="btn btn-success" type="submit">등록하기</button>');
        }
    }
</script>