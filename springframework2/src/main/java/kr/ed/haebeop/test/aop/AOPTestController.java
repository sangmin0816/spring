package kr.ed.haebeop.test.aop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aop/")
public class AOPTestController {

    @GetMapping("/{id}")
    public void get(@PathVariable String id, @RequestParam String name, Model model) {
        System.out.println("--------------- @GetMapping ---------------");
        System.out.println(id + " " + name);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
    }

    @PostMapping
    public void post(@RequestBody UserDTO userDto, Model model) {
        System.out.println("--------------- @PostMapping ---------------");
        System.out.println(userDto);
        model.addAttribute("user", userDto);
    }

    @Timer
    @DeleteMapping("delete")
    public String delete() throws InterruptedException {
        Thread.sleep(1000 * 2);
        return "delete";
    }
}
