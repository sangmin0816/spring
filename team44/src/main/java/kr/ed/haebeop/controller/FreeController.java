package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Comment;
import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.service.CommentService;
import kr.ed.haebeop.service.FreeService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/free/*")
public class FreeController {

    @Autowired
    private FreeService freeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    HttpSession session;


    @GetMapping("freeList")		//free/list.do
    public String getfreeList(HttpServletRequest request, Model model) throws Exception {


        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);
        int total = freeService.totalCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);


        List<Free> freeList = freeService.freeList(page);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);


        model.addAttribute("freeList", freeList);
        return "/free/freeList";
    }

    @GetMapping("freeGet")	//free/get.do?fno=1
    public String getfreeDetail(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeDetail(fno);
        List<Comment> commentList = commentService.commentList(fno);
        model.addAttribute("commentList", commentList);
        model.addAttribute("dto", dto);
        model.addAttribute("fno", fno);
        System.out.println("dto : " + dto);
        System.out.println("commentList : " + commentList);
        System.out.println("fno : " + fno);
        return "/free/freeDetail";
    }

    @GetMapping("freeInsert")
    public String insertForm(HttpServletRequest request, Model model) throws Exception {
        return "/free/freeInsert";
    }

    @PostMapping("freeInsert")
    public String freeInsert(HttpServletRequest request, Model model) throws Exception {
        String sid = session.getAttribute("sid") != null ? (String) session.getAttribute("sid") : "";
        Free dto = new Free();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setAuthor(sid);
        freeService.freeInsert(dto);
        return "redirect:/free/freeList";
    }

    @GetMapping("freeDelete")
    public String freeDelete(HttpServletRequest request, Model model) throws Exception {
        String sid = session.getAttribute("sid") != null ? (String) session.getAttribute("sid") : "";
        int fno = Integer.parseInt(request.getParameter("fno"));
        freeService.freeDelete(fno);
        if(!sid.equals("admin")) {
            return "redirect:/free/freeList";
        } else {
            return "redirect:/admin/freeListAdmin";
        }
    }

    @GetMapping("freeUpdate.do")
    public String editForm(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeDetail(fno);
        model.addAttribute("dto", dto);
        return "/free/freeUpdate";
    }


    @PostMapping("freeUpdate")
    public String freeUpdate(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = new Free();
        dto.setFno(fno);
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        freeService.freeUpdate(dto);
        return "redirect:/free/freeList.do";
    }
}
