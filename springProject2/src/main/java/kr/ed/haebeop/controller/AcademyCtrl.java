package kr.ed.haebeop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.icu.text.SimpleDateFormat;
import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.domain.Reservation;
import kr.ed.haebeop.domain.RestDay;
import kr.ed.haebeop.domain.Unavailable;
import kr.ed.haebeop.service.AcademyService;
import kr.ed.haebeop.service.MemberService;
import kr.ed.haebeop.service.ReservationService;
import kr.ed.haebeop.service.UnavailableService;
import kr.ed.haebeop.util.DatePicker;
import kr.ed.haebeop.util.RestDayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/academy/*")
public class AcademyCtrl {
    @Autowired
    AcademyService academyService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    UnavailableService unavailableService;

    @Autowired
    MemberService memberService;

    @GetMapping("academyCalendar")
    public String calendar(Model model) throws Exception{
        int ano = 1;

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String yyyymmdd = dateFormat.format(today);
        String yyyy= yyyymmdd.substring(0,4);
        String mm = yyyymmdd.substring(4, 6);
        String dd = yyyymmdd.substring(6);

        DatePicker datePicker = new DatePicker();

        List<String[]> calList = datePicker.getDatePicker(yyyy+mm);
        String cal = "";
        for(String[] row:calList){
            cal = cal + "<tr>";
            for(String col:row){
                cal = cal + ("<td>"+col+"</td>");
            }
            cal = cal + "</tr>";
        }

        RestDayUtil restUtil = new RestDayUtil();
        List<RestDay> restList = restUtil.getRestDayList(yyyy+mm);

        Unavailable unavailable = new Unavailable();
        unavailable.setAcademy(ano);
        unavailable.setRdate(yyyy+"-"+mm+"-"+dd);

        List<Unavailable> unavailableList = unavailableService.unavailableAcademyMonth(unavailable);

        Map<Integer, String> restDays = new HashMap<>();

        for(RestDay r:restList){
            int rd = Integer.parseInt(r.getLocdate().substring(6));
            restDays.put(rd,  r.getDateName());
        }

        Map<Integer, String> udayList = new HashMap<>();
        for(Unavailable u: unavailableList){
            int rd = Integer.parseInt(u.getRdate().substring(8));
            String reason = u.getReason();
            udayList.put(rd, reason);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String restDayList = objectMapper.writeValueAsString(restDays);
        String unDayList = objectMapper.writeValueAsString(udayList);


        model.addAttribute("yyyy", yyyy);
        model.addAttribute("mm", mm);
        model.addAttribute("cal", cal);
        model.addAttribute("calList", calList);
        model.addAttribute("today", dd);
        model.addAttribute("restDayList", restDayList);
        model.addAttribute("unavailableList", unDayList);
        model.addAttribute("ano", ano);

        return "/academy/academyCalendar";
    }

    @PostMapping("insertUnavailable")
    public String insertUnavailable(Model model, HttpServletRequest request){

        int ano = Integer.parseInt(request.getParameter("ano"));
        String rdate = request.getParameter("rdate");
        String reason = request.getParameter("reason");

        Unavailable unavailable = new Unavailable();
        unavailable.setAcademy(ano);
        unavailable.setRdate(rdate);
        unavailable.setReason(reason);

        unavailableService.unavailableInsert(unavailable);

        model.addAttribute("msg", "등록되었습니다.");
        model.addAttribute("url", "/academy/academyCalendar");

        return "/include/alert";
    }

    @PostMapping("deleteUnavailable")
    public String deleteUnavailable(Model model, HttpServletRequest request){

        int ano = Integer.parseInt(request.getParameter("ano"));
        String rdate = request.getParameter("rdate");

        Unavailable unavailable = new Unavailable();
        unavailable.setAcademy(ano);
        unavailable.setRdate(rdate);

        unavailableService.unavailableDelete(unavailable);

        model.addAttribute("msg", "삭제되었습니다.");
        model.addAttribute("url", "/academy/academyCalendar");

        return "/include/alert";
    }

    @GetMapping("academyReservationList")
    public String academyReservationList(Model model, HttpServletRequest request){
        int ano = 1;

        List<Reservation> reservations = reservationService.reservationAcademyList(ano);
        model.addAttribute("reservationList", reservations);

        return "/academy/academyReservationList";
    }

    @GetMapping("academyReservationGet")
    public String academyReservationGet(Model model, HttpServletRequest request) throws Exception {
        int rno = Integer.parseInt(request.getParameter("rno"));
        Reservation reservation = reservationService.reservationGet(rno);

        Member member = memberService.memberGet(reservation.getId());

        model.addAttribute("reservation", reservation);
        model.addAttribute("member", member);

        return "/academy/academyReservationGet";
    }

    @GetMapping("academyReservationUpdateStatus")
    public String academyReservationUpdateStatus(HttpServletRequest request) throws Exception {
        int rno = Integer.parseInt(request.getParameter("rno"));
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setRno(rno);
        reservation.setStatus(status);

        reservationService.reservationUpdateStatus(reservation);

        return "redirect: academyReservationGet?rno="+rno;
    }
}
