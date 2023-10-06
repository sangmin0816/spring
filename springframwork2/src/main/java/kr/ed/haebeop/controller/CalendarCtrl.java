package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Days365;
import kr.ed.haebeop.domain.Holiday;
import kr.ed.haebeop.util.DatePicker;
import kr.ed.haebeop.util.Holyday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/calendar/")
public class CalendarCtrl {
    @GetMapping("calendar")
    public String calendar(){
        return "/test/calendar";
    }

    @GetMapping("cal1")
    public String callHoliday(@RequestParam("yyyy") String yyyy, Model model){
        DatePicker datePicker = new DatePicker();
        List<Days365> daysList = datePicker.generatorHoliday(yyyy);  //해당 년도의 국경일 생성
        List<String> holiList = new ArrayList<>();
        for(Days365 day:daysList){  //국경일 출력
            Calendar cal = day.getCal();
            String wk = datePicker.generateWeekDay2(cal);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int date = cal.get(Calendar.DAY_OF_MONTH);
            String holi = year+"-"+month+"-"+date+"("+wk+") : "+day.getName();

            holiList.add(holi);
        }
        model.addAttribute("yyyy", yyyy);
        model.addAttribute("holiList", holiList);
        return "/test/holiday";
    }

    @GetMapping("cal2")
    public String callHolydayOfMonth(@RequestParam("sunDate") String sunDate, Model model) throws Exception {
        Holyday holi = new Holyday();
        List<Holiday> holiList = holi.getHolidayList(sunDate);

        model.addAttribute("yyyymm", sunDate);
        model.addAttribute("holiList", holiList);
        return "/test/holiday2";
    }

    @GetMapping("cal3")
    public String callCalendarOfMonth(@RequestParam("yyyymm") String yyyymm, Model model) throws Exception {
        DatePicker datePicker = new DatePicker();
        List<String[]> calList = datePicker.getDatePicker(yyyymm);
        String cal = "";
        for(String[] row:calList){
            cal = cal + "<tr>";
            for(String col:row){
                cal = cal + ("<td>"+col+"</td>");
            }
            cal = cal + "</tr>";
        }
        model.addAttribute("yyyymm", yyyymm);
        model.addAttribute("cal", cal);
        model.addAttribute("calList", calList);
        return "/test/calendarMonth";
    }
}
