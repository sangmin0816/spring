package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/json/")
public class JsonController {
    @Autowired
    private TestService testService;

    @GetMapping("get/{num}")
    @ResponseBody
    public TestVO viewTest(@PathVariable int num) throws Exception {
        TestVO test = testService.testGet(num);
        return test;
    }

    @GetMapping("insert")
    public String insert(){
        return "/test/testInsert";
    }

    @PostMapping("insertBody")
    @ResponseBody
    public TestVO insertBody(@RequestBody TestVO test) throws Exception{
        testService.testInsert(test);
        return test;
    }

    @PostMapping("insertModel")
    @ResponseBody
    public TestVO insertModel(@ModelAttribute TestVO test) throws Exception{
        testService.testInsert(test);
        return test;
    }

}
