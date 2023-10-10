<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::인사말</title>
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


        .page .intro .intro_tit { font-family: SBAggroB; font-size: 50px; display: block; width: 800px; margin: 50px auto; letter-spacing:-0.048em; }
        .page .intro .intro_con { font-family: HakgyoansimWoojuR; font-size: 20px; display: block; width: 800px; height: auto; margin: 30px auto;  }
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
                        <h1 class="is-capitalize text-lg font-happy">인사말</h1>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="section blog-wrap container">
        <section class="page" id="page1">
            <div class="intro">
<%--                <img src="${headPath}/resources/image/sub/icon2.png" alt="별">--%>
                <h3 class="intro_tit">TSpoon</h3>
                <p class="intro_con">
                    티스푼은 그로우앤조이 기업에서 자랑스럽게 제공하는 교육 웹사이트입니다. 우리는 학부모 커뮤니티를 위해 티스푼을 만들었습니다. 학부모들은 자녀의 교육과 성장에 큰 관심을 가지고 있으며, 그 관심을 더 나은 방향으로 이끌고자 노력하고 있습니다. 이를 위해 티스푼은 학부모들에게 필요한 정보, 도구 및 지원을 제공하여 학부모들이 자녀의 교육 경험을 최적화하고 더 나은 미래를 위한 토대를 마련할 수 있도록 돕고자 합니다.
                    <br><br>
                    우리의 목표는 학부모들이 자녀의 교육 과정을 이해하고, 어떻게 더 나은 교육 환경을 조성할 수 있는지에 대한 통찰력을 제공하는 것입니다. 티스푼은 유용한 정보와 교육 자료뿐만 아니라, 학부모들 간의 소통을 촉진하고 지식을 공유하는 플랫폼으로서도 기능합니다. 우리는 학부모들 간의 연결을 강화하고, 함께 성장하며 자녀의 미래를 밝게 비추는 곳으로 티스푼을 만들고 있습니다.
                    <br><br>
                    티스푼은 학부모들과 자녀의 교육에 대한 열정을 공유하며, 끊임없이 더 나은 방법을 모색하고 제공하고자 합니다. 우리와 함께 학부모로서의 역할을 더욱 효과적으로 수행하고, 자녀의 성장과 발전을 지원하며, 행복하고 풍요로운 가정을 만들어 나갑시다.
                    <br><br>
                    감사합니다.
                    <br><br>
                    (그로우앤조이 기업)
                    <br><br>
                    티스푼 팀 드림
                </p>
            </div>

        </section>
    </section>


</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
