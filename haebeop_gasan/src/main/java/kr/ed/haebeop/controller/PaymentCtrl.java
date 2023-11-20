package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.*;
import kr.ed.haebeop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentCtrl {
    @Autowired
    HttpSession session;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StorageService storageService;

    //    회원 페이지
    @GetMapping("/rrr.do")
    public String rrr( Model model) throws Exception {

        return "/payment/rrr";

    }
    @GetMapping("payinsert.do")
    public String insertpay(@RequestParam int lno, HttpServletRequest req, Model model )throws Exception{
        String id = (String) session.getAttribute("sid");
        Member mem = memberService.memberGet(id);
        Course lecture = courseService.courseGet(lno);


        model.addAttribute("mem", mem);
        model.addAttribute("lecture", lecture);

        return "/payment/paymentInsert";
    }

    @GetMapping("paymentInsert")
    public String paymentInsert(HttpServletRequest request, Model model){
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        String id = (String) session.getAttribute("sid");
        Member mem = memberService.memberGet(id);
        model.addAttribute("mem", mem);

        CourseList course = new CourseList();
        Course c = courseService.courseGet(courseNo);
        course.setCourse(c);
        Teacher t = teacherService.teacherGet(c.getTeacherNo());
        course.setTeacher(t);
        Storage s = storageService.storageGet(t.getImageFile());
        course.setTeacherImg(s);

        model.addAttribute("lecture", course);

        return "/payment/paymentInsert";
    }

    @PostMapping("paymentInsert")
    public String paymentInsertPro(@ModelAttribute Payment payment, @ModelAttribute Delivery delivery, Model model )throws Exception{
        String id = (String) session.getAttribute("sid");
        Member mem = memberService.memberGet(id);
        payment.setId(mem.getId());
        delivery.setMemId(mem.getId());

        paymentService.insertpayment(payment, delivery);

        return "redirect:/payment/list.do";
    }


    @PostMapping("payinsert.do")
    public String insertpaypro(@ModelAttribute Payment payment, @ModelAttribute Delivery delivery, @ModelAttribute Member member, Model model )throws Exception{
        System.out.println(payment.toString());
        System.out.println(delivery.toString());
        paymentService.insertpayment(payment, delivery);

        return "redirect:/payment/list.do";
    }

//    회원 페이지
    @GetMapping("/paylistMember.do")
    public String paymentList(HttpServletRequest request, Model model) throws Exception {
        String id = (String) session.getAttribute("sid");

        List<Payment> paymentList = paymentService.paymentList_Member(id);
        Member member = memberService.memberGet(id);

        model.addAttribute("paymentList", paymentList);
        model.addAttribute("mem", member);
        return "/member/paymentList";

    }

}