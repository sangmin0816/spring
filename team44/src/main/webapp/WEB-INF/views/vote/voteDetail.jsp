<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>티스푼::투표</title>
    <jsp:include page="../include/head.jsp" />
    <link rel="stylesheet" href="${path }/resources/css/sub.css">
    <style>
        .mine {text-decoration:underline;color:var(--main-color);}
    </style>
</head>
<body>
<div class="wrap">
    <header class="hd" id="hd">
        <jsp:include page="../include/header.jsp" />
    </header>
    <div class="container is-fullhd">
        <nav class="breadcrumb is-right" aria-label="breadcrumbs">
            <ul>
                <li><a href="/">HOME</a></li>
                <li class="is-active"><a href="${path }/vote/voteList.jsp" aria-current="page">투표 상세보기</a></li>
            </ul>
        </nav>
        <section class="section">
            <h2 class="title has-text-centered">티이슈 - 상세보기</h2>

            <h3 class="is-size-2 has-text-centered has-text-weight-bold mt-5">${vote.title }</h3>

            <div class="columns is-mobile is-four-fifths is-offset-1 my-2">
                <div class="column is-half">${vote.startDate } ~ ${vote.finishDate}</div>
                <div class="column is-half has-text-right">참여시 ${vote.addPt }포인트 증정</div>
            </div>

            <c:if test="${voteYn && vote.stateYn }">
                <div class="columns is-multiline">
                    <c:forEach items="${voteCountList }" var="voteAnswer" varStatus="status">
                        <div class="column is-4">
                            <div class="card shadow has-text-centered">
                                <c:if test="${cnt != 0 }">
                                    <c:set var="lnoTotal" value="${(voteAnswer.cnt / cnt) * 100 }" />
                                    <div class="is-relative rounded-top progress-wrapper" data-color="${voteAnswer.colorNum }">
                                        <div class="wave" data-progress="<fmt:formatNumber value="${lnoTotal }" type="pattern" pattern="0" />%"></div>
                                    </div>
                                    <div class="card-content has-background-white">
                                        <h4 <c:if test="${voteUserInfo.lno == voteAnswer.lno || (cnt != 0 && sid.equals('admin') && getMaxLno.lno == voteAnswer.lno)}">class="mine"</c:if>>${voteAnswer.title } (<fmt:formatNumber value="${lnoTotal }" type="pattern" pattern="0" />%)</h4>
                                    </div>
                                </c:if>
                                <c:if test="${cnt == 0 }">
                                    <div class="is-relative rounded-top progress-wrapper" data-color="${voteAnswer.colorNum }">
                                        <div class="wave" data-progress="0%"></div>
                                    </div>
                                    <div class="card-content has-background-white">
                                        <h4>${voteAnswer.title } (0%)</h4>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>

            <div class="columns is-multiline is-mobile is-four-fifths is-offset-1 mt-5">

                <c:if test="${!voteYn && vote.stateYn }">
                    <hr />
                    <input type="hidden" value="${vote.vno }" id="vno">
                    <input type="hidden" value="${vote.addPt }" id="addPt">
                    <input type="hidden" value="${sid }" id="loginId">
                    <input type="hidden" value="${path }" id="pathStr">
                    <c:forEach var="answer" items="${voteList }" varStatus="status">
                        <div class="column is-half">
                            <div class="vote_area">
                                <input type="radio" id="vote${status.count }" name="vote" value="${answer.lno }">
                                <label class="box" for="vote${status.count }">${answer.title }</label>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="columns is-multiline is-mobile is-four-fifths is-offset-1 mt-5">
                    <div class="column if-full has-text-centered">
                        <button type="button" class="voteBtn button is-mainColor">투표하기</button>
                    </div>

                    <script>
                        $(function(){
                            $(".voteBtn").on('click', function(){

                                var selCnt = $("input[name=vote]:checked").length;
                                if(selCnt < 1){
                                    alert("보기를 선택 후 투표해주세요.");
                                    return;
                                }

                                var loginId = $("#loginId").val();
                                var pathStr = $("#pathStr").val();
                                if(loginId == ""){
                                    alert("로그인을 부탁드립니다.");
                                    location.href = pathStr + "/member/login.do";
                                    return false;
                                }

                                if(confirm("투표 하시겠습니까?")){
                                    var vno = $("#vno").val();
                                    var lno = $("input[name=vote]:checked").val();
                                    var pt = $("#addPt").val();
                                    var param = {
                                        vno: vno,
                                        lno: lno,
                                        pt: pt
                                    };
                                    $.ajax({
                                        url: pathStr + '/vote/addVote.do',
                                        type: 'POST',
                                        data:param,
                                        success:function(result) {
                                            if(result == "success") {
                                                location.reload();
                                            }
                                            if(result == "error"){
                                                alert("로그인을 부탁드립니다.");
                                                location.href = pathStr + "/member/login.do";
                                            }
                                        },error: function (result) {
                                            console.log(result.responseText);
                                        }
                                    });
                                }
                            });
                        });

                    </script>
                    <hr />
                </c:if>

                <c:if test="${!vote.stateYn }">
                    <c:forEach items="${voteList }" var="voteAnswer" varStatus="status">
                        <div class="column is-half">
                            <div class="vote_li box<c:if test="${getMaxLno.lno == voteAnswer.lno }"> check</c:if>">
                                <p class="is-size-3 has-text-weight-semibold"><c:if test="${getMaxLno.lno == voteAnswer.lno }">[확정] </c:if>${voteAnswer.title }</p>
                                <c:set var="lnoTotal" value="${(voteAnswer.cnt / cnt) * 100 }" />
                                <p><span>투표수 : ${voteAnswer.cnt }</span> | <span>투표율 : <fmt:formatNumber value="${lnoTotal }" type="pattern" pattern="0.00" /> %</span></p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

                <div class="column is-full has-text-centered my-5">
                    ${vote.content }
                </div>

            </div>

            <div class="buttons is-right">
                <a href="${path }/vote/list.do" class="button is-mainColor">목록</a>
            </div>

            <!-- 댓글 넣을 예정 -->
        </section>
    </div>
    <footer class="ft" id="ft">
        <jsp:include page="../include/footer.jsp" />
    </footer>
</div>
</body>
</html>

<script>
    $('[data-background]').each(function () {
        $(this).css({
            'background-image': 'url(' + $(this).data('background') + ')'
        });
    });

    // background color
    $('[data-color]').each(function () {
        $(this).css({
            'background-color': $(this).data('color')
        });
    });

    // progress bar
    $('[data-progress]').each(function () {
        $(this).css({
            'bottom': $(this).data('progress')
        });
    });
</script>