package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Comment;
import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.service.CommentService;
import kr.ed.haebeop.service.FreeService;
import kr.ed.haebeop.service.MemberService;
import kr.ed.haebeop.service.NoticeService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class AdminCtrl {

    @Autowired
    HttpSession session;

    @Autowired
    private MemberService memberService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private FreeService freeService;
    @Autowired
    private CommentService commentService;


    @GetMapping("adminBoard")
    public String adminBoard(){
        return "/admin/adminBoard";
    }

    //member------------------------------------------------
    @GetMapping("adminMemberList2")
    public String adminMemberList2(String type, String keyword, String curpage, Model model){
        int curPage = curpage != null ? Integer.parseInt(curpage) : 1;
        System.out.println(curPage);

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);

        int total = memberService.memberCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<Member> memberList = memberService.memberList(page);
        model.addAttribute("memberList", memberList);
        return "/admin/member/memberList";
    }

    @GetMapping("adminMemberList")
    public String adminMemberList(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);

        int total = memberService.memberCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<Member> memberList = memberService.memberList(page);
        model.addAttribute("memberList", memberList);
        return "/admin/member/memberList";
    }

    @GetMapping("adminMemberGet")
    public String adminMemberGet(String id, Model model){
        Member member = memberService.memberGet(id);
        model.addAttribute("member", member);

        return "/admin/member/memberGet";
    }

    @GetMapping("adminMemberDeactive")
    public String adminMemberDeactive(String id){
        Member member = memberService.memberGet(id);
        member.setActive(false);
        memberService.memberActiveUpdate(member);

        return "redirect: adminMemberList";
    }


    //notice------------------------------------------------

    @RequestMapping(value = "List", method = RequestMethod.GET)
    public String noticeList(Model model) throws Exception{
        Page page = new Page();
        List<Notice> noticeList = noticeService.noticeList(page);
        model.addAttribute("noticeList", noticeList);
        return "/admin/notice/noticeList";
    }

    @GetMapping("Get")
    public String noticeGet(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(no);
        model.addAttribute("notice", notice);
        return "/admin/notice/noticeGet";
    }

    @GetMapping("Insert")
    public String noticeInsert(HttpServletRequest request, Model model) throws Exception{
        return "/admin/notice/noticeInsert";
    }

    @PostMapping("Insert")
    public String noticeInsertpro(HttpServletRequest request, Model model) throws Exception{
        Notice notice = new Notice();
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeInsert(notice);
        return "redirect:/admin/List";
    }

    @GetMapping("Update")
    public String noticeUpdate(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(no);
        model.addAttribute("notice", notice);
        return "/admin/notice/noticeUpdate";
    }

    @PostMapping("Update")
    public String noticeUpdatepro(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = new Notice();
        notice.setNoticeNo(no);
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeUpdate(notice);
        return "redirect:/admin/List";
    }

    @GetMapping("Delete")
    public String noticeDelete(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        noticeService.noticeDelete(no);
        return "redirect:/admin/List";
    }

    //free------------------------------------------------
    @GetMapping("FreeListAdmin")		//free/list.do
    public String getfreeList(HttpServletRequest request, Model model) throws Exception {


        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);

        int total;
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
        return "/admin/free/freeList";
    }

    @GetMapping("freeGet")	//free/get.do?fno=1
    public String getFree(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeGet(fno);
        List<Comment> commentList = commentService.commentFreeList(fno);
        model.addAttribute("commentList", commentList);
        model.addAttribute("dto", dto);
        model.addAttribute("fno", fno);
        System.out.println("dto : " + dto);
        System.out.println("commentList : " + commentList);
        System.out.println("fno : " + fno);
        return "/admin/free/freeGet";
    }



}