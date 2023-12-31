package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Attendance;
import kr.ed.haebeop.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/attend/*")
public class AttendanceCtrl {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    HttpSession session;

    @RequestMapping(value = "getMyAttend", method = RequestMethod.GET)
    public String AttendanceList(HttpServletRequest request, Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");

        if(sid != null) {

            LocalDate now = LocalDate.now();

            LocalDate monthFirstDate = LocalDate.of(now.getYear(), now.getMonth(), 1);
            String monthFirstDateWeek = String.valueOf(monthFirstDate.getDayOfWeek());

            DateTimeFormatter dateYearMonth = DateTimeFormatter.ofPattern("yyyyMM");
            String yearMonth = now.format(dateYearMonth);
            DateTimeFormatter getDate = DateTimeFormatter.ofPattern("dd");
            String nowDate = now.format(getDate);

            int dayList = now.lengthOfMonth();

            Attendance attendance = new Attendance();
            attendance.setAuthor(sid);
            attendance.setDateYearMonth(yearMonth);

            List<Attendance> attendanceList = attendanceService.attendanceList(attendance);

            boolean pass = false;
            for(Attendance attend : attendanceList) {
                String nowDay = attend.getNowDay();
                if(nowDate.equals(nowDay)) {
                    pass = true;
                }
            }

            DateTimeFormatter pageYear = DateTimeFormatter.ofPattern("yyyy");
            String currentYear = now.format(pageYear);
            DateTimeFormatter pageMonth = DateTimeFormatter.ofPattern("MM");
            String currentMonth = now.format(pageMonth);

            model.addAttribute("attendanceList", attendanceList);
            model.addAttribute("dayList", dayList);
            model.addAttribute("pass", pass);
            model.addAttribute("monthFirstDateWeek", monthFirstDateWeek);
            model.addAttribute("currentYear", currentYear);
            model.addAttribute("currentMonth", currentMonth);

            return "/attendance/attendanceList";

        } else {

            return "redirect:/";

        }

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String AttendanceInsertPro(HttpServletRequest request, Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");

        LocalDate now = LocalDate.now();

        DateTimeFormatter dateYearMonth = DateTimeFormatter.ofPattern("yyyyMM");
        String yearMonth = now.format(dateYearMonth);
        DateTimeFormatter getDate = DateTimeFormatter.ofPattern("dd");
        String nowDate = now.format(getDate);

        Attendance attendance = new Attendance();
        attendance.setAuthor(sid);
        attendance.setDateYearMonth(yearMonth);

        List<Attendance> attendanceList = attendanceService.attendanceList(attendance);

        boolean check = true;
        for(Attendance attend : attendanceList) {
            String nowDay = attend.getNowDay();
            if(nowDate.equals(nowDay)) {
                check = false;
            }
        }

        if(sid != null && check) {

            attendance.setNowDay(nowDate);

            attendanceService.attendanceUserInsert(attendance);

            return "redirect:/attend/getMyAttend";

        } else if(!check) {

            return "redirect:/attend/getMyAttend";

        } else {

            return "redirect:/";

        }

    }

}