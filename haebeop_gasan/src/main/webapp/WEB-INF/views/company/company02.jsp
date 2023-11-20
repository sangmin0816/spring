<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::연혁</title>
    <%@ include file="../include/head.jsp" %>

    <style>
        @font-face {
            font-family: 'HakgyoansimWoojuR';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-2@1.0/HakgyoansimWoojuR.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
        @font-face {
            font-family: 'SBAggroB';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
    .text-box {
    align-items: center;
    width: 1200px;
    padding: 20px;
    margin: 0 auto;
    border: 1px solid #ccc;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.8s, transform 0.4s;
    display: block;
    }
    .text-box:hover {
    background-color: #ffed88;
    transform: scale(1.05);
    }
    .text-box-content {
    margin-left: 20px;
    }
    .title {
    font-family: SBAggroB;
    font-size: 50px;
    font-weight: bold;
    }
    .history {
    font-family: HakgyoansimWoojuR;
    font-size: 20px;
    color: #555;
    margin-top: 5px;
    }
    </style>
</head>

<body>
<%@ include file="../include/header.jsp" %>

<div class="content">

    <section class="page-title bg-01">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <div class="block has-text-centered">
                        <h1 class="is-capitalize text-lg font-happy">연혁</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="section blog-wrap container">
        <div class="text-box">
            <div class="title">2024</div>
            <div class="text-box-content">
                <div class="history">
                    이곳에 <br>
                    티스푼의 연혁을 적어주세요! <br>
                </div>
            </div>
        </div>

        <div class="text-box">
            <div class="title">2023</div>
            <div class="text-box-content">
                <div class="history">
                    08.17. 2023 올해의 브랜드 최우수상 수상 <br>
                    08.16. 티스푼 홈페이지 오픈<br>
                    08.01. 교육서비스 개발 시작<br>
                    07.31. 교육브랜드 티스푼(Grow&Joy) 설립<br>

                </div>
            </div>
        </div>

    </section>


</div>


</body>
</html>
