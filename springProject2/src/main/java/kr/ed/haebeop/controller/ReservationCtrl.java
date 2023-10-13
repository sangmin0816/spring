package kr.ed.haebeop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.icu.text.SimpleDateFormat;
import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.domain.Reservation;
import kr.ed.haebeop.domain.RestDay;
import kr.ed.haebeop.domain.Unavailable;
import kr.ed.haebeop.service.AcademyService;
import kr.ed.haebeop.service.ReservationService;
import kr.ed.haebeop.service.UnavailableService;
import kr.ed.haebeop.util.DatePicker;
import kr.ed.haebeop.util.PageAcademy;
import kr.ed.haebeop.util.RestDayUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

@Controller
@RequestMapping("/reservation/*")
public class ReservationCtrl {
    @Autowired
    AcademyService academyService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    UnavailableService unavailableService;

    @Autowired
    HttpSession session;

    @GetMapping("calendar")
    public String calendar(Model model, HttpServletRequest request) throws Exception{
        int ano = Integer.parseInt(request.getParameter("ano"));

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

        return "/reservation/calendar";
    }

    @PostMapping("selectDay")
    @ResponseBody
    public Map<Integer, Integer> calendarSelectDay(@RequestParam("rdate") String rdate, @RequestParam("ano") int ano) {
        Academy academy = academyService.academyGet(ano);

        int openhour = Integer.parseInt(academy.getOpentime().substring(0, 2));
        int closehour = Integer.parseInt(academy.getClosetime().substring(0, 2));
        int capacity = academy.getCapacity();
        
        Reservation reserved = new Reservation();
        reserved.setAno(ano);
        reserved.setRdate(rdate);
        
        List<Reservation> reservations = reservationService.reservationAcademyDateList(reserved);

        Map<Integer, Integer> hourCapacity = new HashMap<>();

        for(int i=openhour; i<closehour; i++){
            hourCapacity.put(i, capacity);
        }

        // 예약된 인원 수만큼 빼기
        for(Reservation r: reservations){
            int thisTime = Integer.parseInt(r.getRtime().substring(0, 2));
            int thisCapa = hourCapacity.get(thisTime)-1;
            hourCapacity.put(thisTime, thisCapa);
        }

        return hourCapacity;
    }

    @PostMapping("insertReservation")
    public String insertReservation(Model model, HttpServletRequest request){

        String id = (String) session.getAttribute("sid");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String rdate = request.getParameter("rdate");
        String rtime = request.getParameter("rtime")+":00:00";

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setAno(ano);
        reservation.setRdate(rdate);
        reservation.setRtime(rtime);

        boolean success = reservationService.reservationInsert(reservation);

        if(success){
            model.addAttribute("msg", "상담 신청에 성공했습니다. 관리자 승인 시 예약이 확정됩니다. 마이페이지에서 예약 내역을 확인할 수 있습니다.");
            model.addAttribute("url", "/");
        } else{
            model.addAttribute("msg", "상담 신청에 실패했습니다.");
            model.addAttribute("url", "/reservation/calendar");
        }
        return "/include/alert";
    }

    @GetMapping("academyMapList")
    public String academyMapList(HttpServletRequest request, Model model){
        PageAcademy page = new PageAcademy();

        String city = request.getParameter("sido");
        String district = request.getParameter("gugun");
        String keyword = request.getParameter("keyword");

        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        if(city!=null && !city.isEmpty()){page.setCity(city);}
        if(district!=null && !district.isEmpty()){page.setDistrict(district);}
        if(keyword!=null && !keyword.isBlank()){page.setSearchKeyword(keyword);}

        int total = academyService.academyCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        model.addAttribute("sido", city);
        model.addAttribute("gungu", district);
        model.addAttribute("keyword", keyword);

        List<Academy> academies = academyService.academyList(page);

        model.addAttribute("academyList", academies);

        return "/reservation/academyMapList";
    }

}
