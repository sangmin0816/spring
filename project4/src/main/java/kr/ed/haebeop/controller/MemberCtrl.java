package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.service.MemberService;

import kr.ed.haebeop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member/*")
public class MemberCtrl {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    HttpSession session;

    @Autowired
    BCryptPasswordEncoder pwEncoder;



    @GetMapping("memberGet")
    public String memberGet(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        Member dto = memberService.memberGet(id);
        model.addAttribute("member", dto);
        return "/member/memberGet";
    }

    @GetMapping("term")
    public String term(){
        return "/member/term";
    }

    @GetMapping("login")
    public String loginForm() throws Exception {
        return "/member/login";
    }

    @PostMapping("login")
    public String login(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        Member mem = memberService.login(id);
        if(mem != null) {
            boolean loginSuccess = pwEncoder.matches(pw, mem.getPw());
            if (loginSuccess) {
                session.setAttribute("sid", id);
                session.setAttribute("smembership", mem.getMembership());

                model.addAttribute("msg", "로그인을 성공하셨습니다.");
                model.addAttribute("url", "/");
                return "/include/alert";

            } else {
                model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
                model.addAttribute("url", "/member/login");
                return "/include/alert";
            }
        }else{
        model.addAttribute("msg", "아이디가 없습니다.");
        model.addAttribute("url", "/member/login");
        return "/include/alert";
        }
    }

    @ResponseBody
    @RequestMapping(value="idcheck", method= RequestMethod.POST)
    public boolean idCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");

        boolean noId = true;
        if(memberService.memberGet(id)!=null){
            noId = false;
        }

        return noId;
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, Model model) throws Exception {
        session.removeAttribute("sid");
        model.addAttribute("msg", "로그아웃 하셨습니다.");
        model.addAttribute("url", "/");
        return "/include/alert";
    }

    @GetMapping("join")
    public String join(){return "/member/join";}

    @PostMapping("memberInsert")
    public String memberInsert(HttpServletRequest request,  Model model) throws Exception {
        Member dto = new Member();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String membership = request.getParameter("membership");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String postcode = request.getParameter("postcode");
        int imageFile = Integer.parseInt(request.getParameter("imageFile"));

        dto.setId(id);
        dto.setName(name);
        dto.setMembership(membership);
        dto.setTel(tel);
        dto.setEmail(email);
        dto.setBirth(birth);
        dto.setAddr1(addr1);
        dto.setAddr2(addr2);
        dto.setPostcode(postcode);
        dto.setImageFile(imageFile);

        String ppw = request.getParameter("pw");
        String pw = pwEncoder.encode(ppw);

        dto.setPw(pw);

        memberService.memberInsert(dto);


        if(dto.getMembership().equals("student")){
            model.addAttribute("msg", "가족이 되신 걸 환영합니다.");
        } else{
            model.addAttribute("msg", "미승인 계정이 생성되었습니다. 관리자에게 연락해 승인을 받아주세요.");
        }
        model.addAttribute("url", "/member/login");
        return "/include/alert";
    }

    @GetMapping("memberDelete")
    public String memberDelete(@RequestParam String id, HttpSession session, Model model) throws Exception {
        memberService.memberDelete(id);
        session.invalidate();
        model.addAttribute("msg", "회원탈퇴가 정상적으로 진행되었습니다.");
        model.addAttribute("url", "/");
        return "/include/alert";

    }

    @GetMapping("memberUpdate")
    public String editForm(HttpServletRequest request, Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        Member dto = memberService.memberGet(id);
        model.addAttribute("member", dto);
        return "/member/memberUpdate";
    }

    @PostMapping("memberUpdate")
    public String memberUpdate(HttpServletRequest request, Model model) throws Exception {
        String id = (String) session.getAttribute("sid");

        String oldPw = request.getParameter("oldPw");
        String pw = request.getParameter("pw");
        String pw2 = request.getParameter("pw2");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String postcode = request.getParameter("postcode");
        String birth = request.getParameter("birth");
        String membership = request.getParameter("membership");

        Member dto = new Member();
        dto.setId(id);
        if(pw!=null && pw2!=null && pw.equals(pw2)){
            dto.setPw(pw);
        } else{
            dto.setPw(oldPw);
        }

        dto.setName(name);
        dto.setEmail(email);
        dto.setTel(tel);
        dto.setAddr1(addr1);
        dto.setAddr2(addr2);
        dto.setPostcode(postcode);
        dto.setBirth(birth);
        dto.setMembership(membership);

        memberService.memberUpdate(dto);
        model.addAttribute("dto", dto);
        model.addAttribute("msg", "회원정보가 수정되었습니다.");
        model.addAttribute("url", "/member/get");
        return "/include/alert";
    }
}
