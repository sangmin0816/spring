package kr.ed.haebeop.controller;

import com.ibm.icu.text.SimpleDateFormat;
import kr.ed.haebeop.util.DatePicker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservation/*")
public class ReservationCtrl {
    @GetMapping("calendar")
    public String calendar(Model model) throws Exception{
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String yyyymm = dateFormat.format(today);
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
        model.addAttribute("yyyy", yyyymm.substring(0, 4));
        model.addAttribute("mm", yyyymm.substring(4));
        model.addAttribute("cal", cal);
        model.addAttribute("calList", calList);
        model.addAttribute("today", today.getDay());

        return "/reservation/calendar";
    }
}
