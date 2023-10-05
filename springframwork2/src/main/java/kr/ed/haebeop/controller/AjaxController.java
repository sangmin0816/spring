package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    @GetMapping("")
    public String ajax(){return "/ajax/ajax";}

    @GetMapping("test1")
    public String ajaxTest1(){return "/ajax/test1";}
    @GetMapping("test1pro")
    @ResponseBody
    public String ajaxTest1Pro(){
        return "GET Transfer Test";
    }

    @GetMapping("test2")
    public String ajaxTest2(){return "/ajax/test2";}

    @PostMapping("test2pro")
    public String ajaxTest2Pro(){
        System.out.println("Test 전송 테스트");
        return "/";
    }

    @GetMapping("test5")
    public String ajaxTest5() {return "/ajax/test5";}

    @GetMapping("test5pro")
    @ResponseBody
    public Human ajaxTest5Pro(@ModelAttribute("human") Human human){
        System.out.println(human.toString());
        return human;
    }

    @GetMapping("test6")
    public String ajaxTest6() {return "/ajax/test6";}

    @PostMapping("test6pro")
    @ResponseBody
    public Human ajaxTest6Pro(@ModelAttribute("human") Human human){
        System.out.println(human.toString());
        return human;
    }

    @GetMapping("test7")
    public String ajaxTest7() {return "/ajax/test7";}

    @PostMapping("test7pro")
    @ResponseBody
    public Human ajaxTest7Pro(@RequestBody Human human){
        System.out.println(human.toString());
        return human;
    }


}
