package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.CourseNotice;
import kr.ed.haebeop.service.CourseNoticeService;
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
@RequestMapping("/courseNotice/*")
public class CourseNoticeCtrl {

    @Autowired
    private CourseNoticeService courseNoticeService;

    @RequestMapping(value = "courseNoticeList", method = RequestMethod.GET)
    public String courseNoticeList(HttpServletRequest request, Model model) throws Exception{
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
            case "title":
                total = courseNoticeService.courseNoticeTitleCount(page);
                break;
            case "content":
                total = courseNoticeService.courseNoticeContentCount(page);
                break;
            default:
                total = courseNoticeService.courseNoticeCount(courseNo);
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);


        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<CourseNotice> courseNoticeList;
        switch (type){
            case "title":
                courseNoticeList = courseNoticeService.courseNoticeTitleList(page);
                break;
            case "content":
                courseNoticeList = courseNoticeService.courseNoticeContentList(page);
                break;
            default:
                courseNoticeList = courseNoticeService.courseNoticePageList(page);
        }

        model.addAttribute("courseNo", courseNo);
        model.addAttribute("courseNoticeList", courseNoticeList);
        return "/course/courseNotice/courseNoticeList";
    }

    @GetMapping("courseNoticeGet")
    public String courseNoticeGet(HttpServletRequest request, Model model) throws Exception{
        int courseNoticeNo = Integer.parseInt(request.getParameter("no"));
        CourseNotice courseNotice = courseNoticeService.courseNoticeGet(courseNoticeNo);
        model.addAttribute("courseNotice", courseNotice);
       return "/course/courseNotice/courseNoticeGet";
    }

    @GetMapping("courseNoticeInsert")
    public String courseNoticeInsert(HttpServletRequest request, Model model) throws Exception{
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        model.addAttribute("courseNo", courseNo);

        return "/course/courseNotice/courseNoticeInsert";
    }

    @PostMapping("courseNoticeInsert")
    public String courseNoticeInsertpro(HttpServletRequest request, Model model) throws Exception{
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        CourseNotice dto = new CourseNotice();
        dto.setCourseNo(courseNo);
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        courseNoticeService.courseNoticeInsert(dto);

        return "redirect: courseNoticeList?courseNo="+courseNo;
    }
    @GetMapping("courseNoticeUpdate")
    public String courseNoticeUpdate(HttpServletRequest request, Model model) throws Exception{
        int courseNoticeNo = Integer.parseInt(request.getParameter("no"));

        CourseNotice courseNotice = courseNoticeService.courseNoticeGet(courseNoticeNo);

        model.addAttribute("courseNotice", courseNotice);

        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        model.addAttribute("courseNo", courseNo);
        return "/course/courseNotice/courseNoticeUpdate";
    }

    @PostMapping("courseNoticeUpdate")
    public String courseNoticeUpdatepro(HttpServletRequest request, Model model) throws Exception{
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        int no = Integer.parseInt(request.getParameter("no"));
        CourseNotice courseNotice = courseNoticeService.courseNoticeGet(no);

        courseNotice.setTitle(request.getParameter("title"));
        courseNotice.setContent(request.getParameter("content"));
        courseNoticeService.courseNoticeUpdate(courseNotice);

        return "redirect: courseNoticeList?courseNo="+courseNo;
    }

    @GetMapping("courseNoticeDelete")
    public String courseNoticeDelete(HttpServletRequest request) throws Exception{
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        int courseNoticeNo = Integer.parseInt(request.getParameter("no"));

        courseNoticeService.courseNoticeDelete(courseNoticeNo);
        return "redirect: courseNoticeList?courseNo="+courseNo;
    }

}
