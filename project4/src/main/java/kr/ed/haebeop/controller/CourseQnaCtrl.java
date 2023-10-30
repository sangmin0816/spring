package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.CourseQna;
import kr.ed.haebeop.service.CourseQnaService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/courseQna/*")
public class CourseQnaCtrl {
    @Autowired
    private CourseQnaService courseQnaService;

    // CourseQna
    @GetMapping("courseQnaList")
    public String courseQnaList(HttpServletRequest request, Model model) throws Exception {
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
        switch(type){
            case "title":
                total = courseQnaService.courseQnaTitleCount(page);
                break;
            case "content":
                total = courseQnaService.courseQnaContentCount(page);
                break;
            case "id":
                total = courseQnaService.courseQnaIdCount(page);
                break;
            default:
                total = courseQnaService.courseQnaCount(courseNo);
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<CourseQna> courseQnaList;
        switch(type){
            case "title":
                courseQnaList = courseQnaService.courseQnaTitleList(page);
                break;
            case "content":
                courseQnaList = courseQnaService.courseQnaContentList(page);
                break;
            case "id":
                courseQnaList = courseQnaService.courseQnaIdList(page);
                break;
            default:
                courseQnaList = courseQnaService.courseQnaPageList(page);
        }

        model.addAttribute("courseNo", courseNo);
        model.addAttribute("courseQnaList", courseQnaList);
        return "/course/courseQna/courseQnaList";
    }

    @GetMapping("courseQnaGet")
    public String courseQnaGet(HttpServletRequest request, Model model) throws Exception {
        int qno = Integer.parseInt(request.getParameter("qno"));
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        CourseQna dto = courseQnaService.courseQnaGet(qno);

        model.addAttribute("courseQna", dto);
        model.addAttribute("courseNo", courseNo);
        return "/course/courseQna/courseQnaGet";
    }

    @GetMapping("courseQnaInsert")
    public String courseQnaInsertForm(HttpServletRequest request, Model model) throws Exception {
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        int lev = Integer.parseInt(request.getParameter("lev"));
        int par = Integer.parseInt(request.getParameter("par"));

        model.addAttribute("lev", lev);
        model.addAttribute("par", par);
        model.addAttribute("courseNo", courseNo);

        return "/course/courseQna/courseQnaInsert";
    }

    @PostMapping("courseQnaInsert")
    public String courseQnaInsert(HttpServletRequest request) throws Exception {
        CourseQna dto = new CourseQna();
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        dto.setCourseNo(courseNo);
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setId(request.getParameter("author"));
        dto.setLev(Integer.parseInt(request.getParameter("lev")));
        dto.setPar(Integer.parseInt(request.getParameter("par")));

        courseQnaService.courseQnaInsert(dto);
        return "redirect:courseQnaList?courseNo="+courseNo;
    }

    @GetMapping("courseQnaDelete")
    public String courseQnaDelete(HttpServletRequest request) throws Exception {
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        int qno = Integer.parseInt(request.getParameter("qno"));
        courseQnaService.courseQnaDelete(qno);

        return "redirect:courseQnaList?courseNo="+courseNo;
    }

    @GetMapping("courseQnaUpdate")
    public String courseQnaUpdateForm(HttpServletRequest request, Model model) throws Exception {
        int qno = Integer.parseInt(request.getParameter("qno"));
        CourseQna dto = courseQnaService.courseQnaGet(qno);
        model.addAttribute("courseQna", dto);

        return "/course/courseQna/courseQnaUpdate";
    }

    @PostMapping("courseQnaUpdate")
    public String courseQnaUpdate(HttpServletRequest request) throws Exception {
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        int qnaNo = Integer.parseInt(request.getParameter("qno"));

        CourseQna dto = courseQnaService.courseQnaGet(qnaNo);

        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));

        courseQnaService.courseQnaUpdate(dto);

        return "redirect:courseQnaList?courseNo="+courseNo;
    }
}
