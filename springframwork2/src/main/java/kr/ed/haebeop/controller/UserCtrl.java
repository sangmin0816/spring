package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserCtrl {
    @Autowired
    private UserService userService;

    @Inject
    BCryptPasswordEncoder pwEncoder;

    @Autowired
    HttpSession session;

    @GetMapping("admin/list")
    public String userAdminList(Model model) throws Exception {
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);

        return "/admin/adminUserList";
    }

    @GetMapping("admin/get")
    public String userAdminGet(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        User user = userService.userGet(id);
        model.addAttribute("user", user);

        return "/admin/adminUserGet";
    }

    @GetMapping("get")
    public String userGet(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        User user = userService.userGet(id);
        model.addAttribute("user", user);

        return "/user/userGet";
    }

    @GetMapping("login")
    public String login(){return "/user/login";}

    @GetMapping("logout")
    public String logout(){
        session.removeAttribute("sid");
        return "redirect:/";
    }

    @PostMapping("login1")
    public String login1(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        User user = userService.login1(id);
        if(user!=null && pwEncoder.matches(pw, user.getPw())){
            session.setAttribute("sid", id);
            return "redirect:/";
        }
        else {
            model.addAttribute("msg", "로그인 실패");
            model.addAttribute("url", "/user/login");
            return "/include/alert";
        }
    }

    @PostMapping("login2")
    public String login2(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        User user = new User();
        user.setId(id);
        user.setPw(pw);

        boolean isLoginSuccess = userService.login2(user);

        if(isLoginSuccess){
            return "/";
        }
        else {
            return "/";
        }
    }

    @PostMapping("login3")
    public String login3(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        User user = new User();
        user.setId(id);
        user.setPw(pw);

        boolean isLoginSuccess = userService.login2(user);

        if(isLoginSuccess){
            return "/";
        }
        else {
            return "/";
        }
    }

    @GetMapping("join")
    public String join() {return "/user/join";}

    @PostMapping("join")
    public String join(Model model, HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String postcode = request.getParameter("postcode");
        String birth = request.getParameter("birth");

        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddr1(addr1);
        user.setAddr2(addr2);
        user.setPostcode(postcode);
        user.setBirth(birth);

        userService.userInsert(user);

        return "/";
    }

    @GetMapping("insert")
    public String insert() {return "/admin/insertUser";}

    @PostMapping("insert")
    public String insert(Model model, HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String postcode = request.getParameter("postcode");
        String birth = request.getParameter("birth");

        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddr1(addr1);
        user.setAddr2(addr2);
        user.setPostcode(postcode);
        user.setBirth(birth);

        userService.userInsert(user);

        return "/";
    }

    @GetMapping("update")
    public String update(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");

        User user = userService.userGet(id);
        model.addAttribute(user);

        return "/user/userUpdate";
    }

    @PostMapping("update")
    public String update(Model model, HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String postcode = request.getParameter("postcode");
        String birth = request.getParameter("birth");

        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddr1(addr1);
        user.setAddr2(addr2);
        user.setPostcode(postcode);
        user.setBirth(birth);

        userService.userUpdate(user);

        return "/";
    }

    @GetMapping("delte")
    public String delte(Model model, HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        userService.userDelete(id);

        return "/";
    }
}
