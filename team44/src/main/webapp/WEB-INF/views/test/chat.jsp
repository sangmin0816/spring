<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@include file="../include/head.jsp"%>
    <style>
        .chat-author {font-size: .7rem; color: rgba(128, 128, 128, 0.8);}
    </style>
</head>

<c:set var="sid" value="<%=session.getAttribute("sid")%>"/>

<body>
<%@include file="../include/header.jsp"%>
<div class="container">
    <div class="row">

<%--        Chat List --%>
        <div class="col-6">
            <ul class="list-group" id="chatRoomList" style="margin: 10px 0;">
                <c:forEach var="chatRoom" items="${chatRooms}">
                    <li class="list-group-item list-group-item-success">${chatRoom.name}</li>
                </c:forEach>
            </ul>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Chat Room Name" aria-label="Chat Room Input" aria-describedby="button-addon2" id="name" name="name">
                <button class="btn btn-outline-secondary" id="btnCreate">Create Chat Room</button>
            </div>
        </div>

<%--    Chat Room--%>
        <div class="col-6">
            <section style="background-color: #eee;">
                <div class="container py-5">
                    <div class="row d-flex justify-content-center">
                        <div class="col">

                            <div class="card" id="chat1" style="border-radius: 15px;">
                                <div class="card-header d-flex justify-content-between align-items-center p-3 bg-info text-white border-bottom-0" style="border-top-left-radius: 15px; border-top-right-radius: 15px;">
                                    <i class="fas fa-angle-left"></i>
                                    <p class="mb-0 fw-bold" id="roomId">Live chat</p>
                                    <i class="fas fa-times"></i>
                                </div>

                                <div class="card-body">
                                    <div id="chat-msg-list">
                                        <div class="d-flex flex-row justify-content-start mb-4">
                                            <div class="row p-3">
<%--                                                <p class="chat-author m-0">user1</p>--%>
                                                <div class="p-3" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2);">
                                                    <p class="small mb-0">Hello and thank you for visiting MDBootstrap. Please click the video below.</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-outline">
                                        <div class="row">
                                            <div class="col-10">
                                                <textarea class="form-control" id="chat-text-input" placeholder="Type Your message" aria-label="chat input" rows="3"></textarea>
                                            </div>
                                            <div class="col">
                                                <button class="btn btn-primary" id="btnSend">Send</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </section>
        </div>
    </div>
</div>
</body>
</html>

<script>
    $(document).ready(function(){
        $("#btnCreate").click(function(){
            var data = {name: $("#name").val()};
            $.ajax({
                type: "post",
                url: "${rootPath}/chat/createRoom",
                data: data,
                success: function(res){
                    let newRoom = `<li class="list-group-item list-group-item-success">\${res.name}</li>`;
                    let chatRoomList = document.querySelector("#chatRoomList");
                    chatRoomList.insertAdjacentHTML("beforeend", newRoom);
                },
                error: function(res){console.log("실패", res)},
            })
        })



        $("#btnSend").click(function(){
            var data = { message: $("#chat-text-input").val() }

            $.ajax({
                type: "post",
                url: "${rootPath}/chat/sendMsg",
                data: data,
                success: function(res){
                    let newMsg = `<div class="d-flex flex-row justify-content-start mb-4">
                                            <div class="row p-3">
                                                <div class="p-3" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2);">
                                                    <p class="small mb-0">\${res.messsage}</p>
                                                </div>
                                            </div>
                                        </div>`;
                    let chatMsgList = document.querySelector("#chat-msg-list");
                    chatMsgList.insertAdjacentHTML("beforeend", newMsg);
                },
                error: function(res){console.log("실패", res)},
            })
        })
    })
</script>


<%--Chat Bootstrap css Reference https://mdbootstrap.com/docs/standard/extended/chat/--%>