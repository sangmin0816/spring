package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.domain.Delivery;
import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.domain.Payment;
import kr.ed.haebeop.service.CourseService;
import kr.ed.haebeop.service.MemberService;
import kr.ed.haebeop.service.PaymentService;
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
    @PostMapping("payinsert.do")
    public String insertpaypro(@ModelAttribute Payment payment, @ModelAttribute Delivery delivery, @ModelAttribute Member member, Model model )throws Exception{
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