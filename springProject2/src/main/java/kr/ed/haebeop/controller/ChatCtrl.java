package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.ChatRoom;
import kr.ed.haebeop.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat/")
public class ChatCtrl {

    private final ChatService service;

    @GetMapping("home")
    public String loadHome(Model model){
        model.addAttribute("chatRooms", service.findAllRoom());
        return "/test/chat";
    }

    @PostMapping("createRoom")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam("name") String name){
        return service.createRoom(name);
    }

    @GetMapping("getRoom")
    @ResponseBody
    public ChatRoom getRoom(@RequestParam String roomId) { return service.findRoomById(roomId); }

    @GetMapping("sendMsg")
    public void sendMsg(@RequestParam WebSocketSession session, @RequestParam String message) { service.sendMessage(session, message); }


/*
    @GetMapping("allRoom")
    @ResponseBody
    public List<ChatRoom> findAllRooms(){
        return service.findAllRoom();
    }
    */
}