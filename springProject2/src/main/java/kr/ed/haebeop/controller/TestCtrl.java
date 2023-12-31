package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.People;
import kr.ed.haebeop.domain.Test;
import kr.ed.haebeop.persistence.TestMapper;
import kr.ed.haebeop.persistence.TestMapper2;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/test/")
public class TestCtrl {
    @Autowired
    private TestService testService;

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestMapper2 testMapper2;


    @GetMapping("testList")
    public String getTestList(Model model) throws Exception {
        List<Test> testList = testMapper2.getTestList3();
        model.addAttribute("testList", testList);
        return "/test/testList";
    }

    @GetMapping("get1")  //Get 방식 : <a href="/test/get1.do?id=kkt&pw=1234">Get 방식</a>
    public String get1(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));
        return "/sample/get1";
    }

    @RequestMapping(value="get2", method = RequestMethod.GET)
    public String get2(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));
        return "/sample/get2";
    }

    @RequestMapping(value="get3", method = RequestMethod.GET)
    public String get3(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) throws Exception {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/sample/get3";
    }

    //post 방식이나 특정 템플릿을 써야함 기능이 제공됨
    @RequestMapping(value="get4", method = RequestMethod.GET)
    public String get4(People member, Model model) throws Exception {
        return "/sample/get4";	//${member.id}, ${member.pw}
    }

    @RequestMapping(value="get5", method = RequestMethod.GET)
    public String get5(@ModelAttribute("mem") People member, Model model) throws Exception {
        return "/sample/get5";	//${mem.id}, ${mem.pw}
    }
    //querystring 방식, pathstring
    //GET방식에서 주로 활용하며, springboot나 react에서 전달 가능한 방식임
    @RequestMapping("get6.do/{id}/{pw}")
    public String get6(@PathVariable("id") String id,@PathVariable("pw") String pw, Model model) throws Exception {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/sample/get6";
    }

    @RequestMapping(value="get7", method = RequestMethod.GET)
    public ModelAndView get7(@RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mav) throws Exception {
        mav.addObject("id", id);
        mav.addObject("pw", pw);
        mav.setViewName("/sample/get7");
        return mav;
    }

    @PostMapping("post1")
    public String post1(HttpServletRequest request, Model model) {
        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));
        return "/sample/post1";
    }

    @RequestMapping(value="post2", method = RequestMethod.POST)
    public String post2(HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/sample/post2";
    }

    //@RequestParam("필드명") 은 request.getParameter("필드명")을 대신하여 받아오므로 생략 가능
    @RequestMapping(value="post3", method = RequestMethod.POST)
    public String post3(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) throws Exception {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/sample/post3";
    }

    //POST에서만 가능 --> thymeleaf에서 사용할 것.
    @RequestMapping(value="post4", method = RequestMethod.POST)
    public String post4(People member, Model model) throws Exception {
        return "/sample/post4";	//${member.id}, ${member.pw}
    }

    @RequestMapping(value="post5", method = RequestMethod.POST)
    public String post5(@ModelAttribute("mem") People member, Model model) throws Exception {
        return "/sample/post5";	//${mem.id}, ${mem.pw}
    }

    //GET방식에서 주로 활용하며, spring에서만 저장 목적의 전달만 가능한 방식임
    @RequestMapping("post6/{id}/{pw}")
    public String post6(@PathVariable("id") String id,@PathVariable("pw") String pw, Model model) throws Exception {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/sample/post6";
    }

    @RequestMapping(value="post7", method = RequestMethod.POST)
    public ModelAndView post7(@RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mav) throws Exception {
        mav.addObject("id", id);
        mav.addObject("pw", pw);
        mav.setViewName("/sample/post7");
        return mav;
    }
}
