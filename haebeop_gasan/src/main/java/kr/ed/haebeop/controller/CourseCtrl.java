package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.*;

import kr.ed.haebeop.service.CourseService;

import kr.ed.haebeop.service.RegisterService;
import kr.ed.haebeop.service.StorageService;
import kr.ed.haebeop.service.TeacherService;
import kr.ed.haebeop.util.Page;

import org.apache.ibatis.annotations.Select;
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
@RequestMapping("/course/*")
public class CourseCtrl {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StorageService storageService;

    @Autowired
    HttpSession session;

    @GetMapping("courseList")
    public String courseList(HttpServletRequest request, Model model){
        String id = (String) session.getAttribute("sid");

        List<Register> registerList = registerService.registerCourseList(id);

        List<CourseList> courseList = new ArrayList<>();
        for(Register r: registerList){
            CourseList cl = new CourseList();
            Course c = courseService.courseGet(r.getCourseNo());
            cl.setCourse(c);

            Teacher t = teacherService.teacherGet(c.getTeacherNo());
            cl.setTeacher(t);

            Storage s = storageService.storageGet(t.getImageFile());
            cl.setTeacherImg(s);

            courseList.add(cl);
        }

        model.addAttribute("courseList", courseList);
        return "/course/courseList";
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


        model.addAttribute("course", course);

        return "/course/courseGet";
    }
}
