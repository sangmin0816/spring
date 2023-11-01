package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.*;
import kr.ed.haebeop.service.CourseService;
import kr.ed.haebeop.service.RegisterService;
import kr.ed.haebeop.service.StorageService;
import kr.ed.haebeop.service.TeacherService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register/*")
public class RegisterCtrl {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    HttpSession session;

    @GetMapping("courseList")
    public String courseList(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");

        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);

        int total;
        if(type==null){type="";}
        switch (type){
            case "title":
                total = courseService.courseTitleCount(page);
                break;
            default:
                total = courseService.courseCount();
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);


        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<Course> courses;
        switch (type){
            case "title":
                courses = courseService.courseTitleList(page);
                break;
            default:
                courses = courseService.coursePageList(page);
        }


        List<CourseList> courseList = new ArrayList<>();
        for(Course c: courses){
            CourseList cl = new CourseList();
            cl.setCourse(c);

            Teacher t = teacherService.teacherGet(c.getTeacherNo());
            cl.setTeacher(t);

            Storage s = storageService.storageGet(t.getImageFile());
            cl.setTeacherImg(s);

            int capacity = c.getCapacity();
            int now = registerService.registerStudentCount(c.getCourseNo());
            cl.setRemains(capacity-now);

            courseList.add(cl);
        }

        model.addAttribute("courseList", courseList);
        return "/register/courseList";
    };

    @GetMapping("courseGet")
    public String courseGet(HttpServletRequest request, Model model) throws Exception{
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        CourseList course = new CourseList();
        Course c = courseService.courseGet(courseNo);
        course.setCourse(c);
        Teacher t = teacherService.teacherGet(c.getTeacherNo());
        course.setTeacher(t);
        Storage s = storageService.storageGet(t.getImageFile());
        course.setTeacherImg(s);

        int capacity = c.getCapacity();
        int now = registerService.registerStudentCount(c.getCourseNo());
        course.setRemains(capacity-now);

        String id = (String) session.getAttribute("sid");
        Register register = new Register();
        register.setId(id);
        register.setCourseNo(c.getCourseNo());
        course.setRegistered(registerService.isRegistered(register));

        model.addAttribute("course", course);

        return "/register/courseGet";
    }

    @GetMapping("registerInsert")
    public String registerInsert(HttpServletRequest request){
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        String id = (String) session.getAttribute("sid");
        Register register = new Register();
        register.setCourseNo(courseNo);
        register.setId(id);

        boolean success = registerService.registerInsert(register);
        if(success){
            return "redirect: courseGet?courseNo="+courseNo;
        } else{
            return "redirect: courseList";
        }
    }
}
