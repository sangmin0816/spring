package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Comment;
import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.service.CommentService;
import kr.ed.haebeop.service.FreeService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/free/*")
public class FreeCtrl {

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

        int total;

        if(type==null){type="";}
        switch(type){
            case "title":
                total = freeService.freeTitleCount(page);
                break;
            case "content":
                total = freeService.freeContentCount(page);
                break;
            case "id":
                total = freeService.freeIdCount(page);
                break;
            default:
                total = freeService.freeCount();
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        List<Free> freeList;
        switch(type){
            case "title":
                freeList = freeService.freeTitleList(page);
                break;
            case "content":
                freeList = freeService.freeContentList(page);
                break;
            case "id":
                freeList = freeService.freeIdList(page);
                break;
            default:
                freeList = freeService.freePageList(page);
        }

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);


        model.addAttribute("freeList", freeList);
        return "/community/free/freeList";
    }

    @GetMapping("freeGet")	//free/get.do?fno=1
    public String getfreeDetail(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeGet(fno);

        List<Comment> commentList = commentService.commentFreeList(fno);
        model.addAttribute("commentList", commentList);
        model.addAttribute("dto", dto);
        model.addAttribute("fno", fno);
        return "/community/free/freeDetail";
    }

    @GetMapping("freeInsert")
    public String insertForm(HttpServletRequest request, Model model) throws Exception {
        return "/community/free/freeInsert";
    }

    @PostMapping("freeInsert")
    public String freeInsert(HttpServletRequest request, Model model) throws Exception {
        String sid = session.getAttribute("sid") != null ? (String) session.getAttribute("sid") : "";
        Free dto = new Free();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setId(sid);
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

    @GetMapping("freeUpdate")
    public String editForm(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeGet(fno);
        model.addAttribute("dto", dto);
        return "/community/free/freeUpdate";
    }


    @PostMapping("freeUpdate")
    public String freeUpdate(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = new Free();
        dto.setFreeNo(fno);
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        freeService.freeUpdate(dto);
        return "redirect:/free/freeList";
    }
}
