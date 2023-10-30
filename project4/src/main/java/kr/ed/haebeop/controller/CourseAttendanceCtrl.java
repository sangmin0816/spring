package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.CourseAttendance;
import kr.ed.haebeop.service.CourseAttendanceService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/courseAttendance/*")
public class CourseAttendanceCtrl {

    @Autowired
    private CourseAttendanceService courseAttendanceService;

    @RequestMapping(value = "courseAttendanceList", method = RequestMethod.GET)
    public String courseAttendanceList(HttpServletRequest request, Model model) throws Exception{
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);
        page.setCourseNo(courseNo);

        int total;

        if(type==null){type="";}
        switch (type){
            case "id":
                total = courseAttendanceService.courseAttendanceIdCount(page);
                break;
            default:
                total = courseAttendanceService.courseAttendanceCount(courseNo);
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);


        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<CourseAttendance> courseAttendanceList;
        switch (type){
            case "id":
                courseAttendanceList = courseAttendanceService.courseAttendanceIdList(page);
                break;
            default:
                courseAttendanceList = courseAttendanceService.courseAttendancePageList(page);
        }

        model.addAttribute("courseAttendanceList", courseAttendanceList);
        return "/course/courseAttendance/courseAttendanceList";
    }

    @GetMapping("courseAttendanceGet")
    public String courseAttendanceGet(HttpServletRequest request, Model model) throws Exception{
        int courseAttendanceNo = Integer.parseInt(request.getParameter("no"));
        CourseAttendance courseAttendance = courseAttendanceService.courseAttendanceGet(courseAttendanceNo);
        model.addAttribute("courseAttendance", courseAttendance);
       return "/course/courseAttendance/courseAttendanceGet";

    }
    @GetMapping("courseAttendanceInsert")
    public String courseAttendanceInsert(HttpServletRequest request, Model model) throws Exception{
        return "/course/courseAttendance/courseAttendanceInsert";
    }
    @PostMapping("courseAttendanceInsert")
    public String courseAttendanceInsertpro(HttpServletRequest request, Model model) throws Exception{
        CourseAttendance courseAttendance = new CourseAttendance();

        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        String studentId = request.getParameter("studentId");
        String status = request.getParameter("status");

        courseAttendance.setCourseNo(courseNo);
        courseAttendance.setId(studentId);
        courseAttendance.setStatus(status);

        courseAttendanceService.courseAttendanceInsert(courseAttendance);
        return "redirect: courseAttendanceList";
    }
    @GetMapping("courseAttendanceUpdate")
    public String courseAttendanceUpdate(HttpServletRequest request, Model model) throws Exception{
        int courseAttendanceNo = Integer.parseInt(request.getParameter("no"));
        CourseAttendance courseAttendance = courseAttendanceService.courseAttendanceGet(courseAttendanceNo);

        model.addAttribute("courseAttendance", courseAttendance);
        return "/course/courseAttendance/courseAttendanceUpdate";
    }

    @PostMapping("courseAttendanceUpdate")
    public String courseAttendanceUpdatepro(HttpServletRequest request, Model model) throws Exception{
        int courseAttendanceNo = Integer.parseInt(request.getParameter("no"));
        CourseAttendance courseAttendance = courseAttendanceService.courseAttendanceGet(courseAttendanceNo);

        String status = request.getParameter("status");
        courseAttendance.setStatus(status);

        courseAttendanceService.courseAttendanceUpdate(courseAttendance);
        return "redirect: courseAttendanceList";
    }

    @GetMapping("courseAttendanceDelete")
    public String courseAttendanceDelete(HttpServletRequest request, Model model) throws Exception{
        int courseAttendanceNo = Integer.parseInt(request.getParameter("no"));
        courseAttendanceService.courseAttendanceDelete(courseAttendanceNo);
        return "redirect: courseAttendanceList";
    }

}
