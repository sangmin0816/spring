package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    @GetMapping("")
    public String ajax(){return "/test/ajax";}

    @GetMapping("test1pro")
    @ResponseBody
    public String ajaxTest1Pro(){
        return "GET Transfer Test";
    }


    @PostMapping("test2pro")
    public String ajaxTest2Pro(){
        System.out.println("Test 전송 테스트");
        return "/";
    }


    @GetMapping("test5pro")
    @ResponseBody
    public Human ajaxTest5Pro(@ModelAttribute("human") Human human){
        System.out.println(human.toString());
        return human;
    }


    @PostMapping("test6pro")
    @ResponseBody
    public Human ajaxTest6Pro(@ModelAttribute("human") Human human){
        System.out.println(human.toString());
        return human;
    }


    @PostMapping("test7pro")
    @ResponseBody
    public Human ajaxTest7Pro(@RequestBody Human human){
        System.out.println(human.toString());
        return human;
    }

    @PostMapping("test8pro")
    @ResponseBody
    public Human ajaxTest8Pro(@RequestBody Human human){
        System.out.println(human.toString());
        return human;
    }


}
