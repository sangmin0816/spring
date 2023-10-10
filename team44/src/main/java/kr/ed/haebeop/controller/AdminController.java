package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.*;
import kr.ed.haebeop.service.*;
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
public class AdminController {

    @Autowired
    HttpSession session;

    @Autowired
    private MemberService memberService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private FreeService freeService;
    @Autowired
    private CommentService commentService;

    //member------------------------------------------------
    @RequestMapping(value = "MemberListAdmin.do", method = RequestMethod.GET)
    protected String getMemberList(HttpServletRequest request, Model model) throws Exception {
        request.setAttribute("msg", "회원 목록을 출력합니다.");

        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {

            List<Member> memberList = memberService.memberList();

            request.setAttribute("memberList", memberList);

            return "/admin/memberList";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("get.do")
    public String memberGet(HttpServletRequest request, Model model) throws Exception {
        String id = (String) request.getParameter("id");
        Member member = memberService.memberGet(id);
        model.addAttribute("member", member);
        return "/admin/memberGet";
    }

    @GetMapping("delete.do")
    public String memberDelete(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        String id = request.getParameter("id");
        memberService.memberDelete(id);
        return "redirect:/admin/MemberListAdmin.do";

    }

    //notice------------------------------------------------

    @RequestMapping(value = "List.do", method = RequestMethod.GET)
    public String noticeList(Model model) throws Exception{
        List<Notice> noticeList = noticeService.noticeList();
        model.addAttribute("noticeList", noticeList);
        return "/admin/noticeList";
    }

    @GetMapping("Get.do")
    public String noticeGet(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(no);
        model.addAttribute("notice", notice);
        return "/admin/noticeGet";
    }

    @GetMapping("Insert.do")
    public String noticeInsert(HttpServletRequest request, Model model) throws Exception{
        return "/admin/noticeInsert";
    }

    @PostMapping("Insert.do")
    public String noticeInsertpro(HttpServletRequest request, Model model) throws Exception{
        Notice notice = new Notice();
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeInsert(notice);
        return "redirect:/admin/List.do";
    }

    @GetMapping("Update.do")
    public String noticeUpdate(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(no);
        model.addAttribute("notice", notice);
        return "/admin/noticeUpdate";
    }

    @PostMapping("Update.do")
    public String noticeUpdatepro(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        Notice notice = new Notice();
        notice.setNo(no);
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeUpdate(notice);
        return "redirect:/admin/List.do";
    }

    @GetMapping("Delete.do")
    public String noticeDelete(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        noticeService.noticeDelete(no);
        return "redirect:/admin/List.do";
    }

    //free------------------------------------------------
    @GetMapping("FreeListAdmin.do")		//free/list.do
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
        return "/admin/freeList";
    }

    @GetMapping("freeGet.do")	//free/get.do?fno=1
    public String getFree(HttpServletRequest request, Model model) throws Exception {
        int fno = Integer.parseInt(request.getParameter("fno"));
        Free dto = freeService.freeDetail(fno);
        List<Comment> commentList = commentService.commentList(fno);
        model.addAttribute("commentList", commentList);
        model.addAttribute("dto", dto);
        model.addAttribute("fno", fno);
        System.out.println("dto : " + dto);
        System.out.println("commentList : " + commentList);
        System.out.println("fno : " + fno);
        return "/admin/freeGet";
    }

    //vote------------------------------------------------
    @RequestMapping(value = "VoteMemberListAdmin.do", method = RequestMethod.GET)
    public String getVoteList(HttpServletRequest request, Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        if(sid != null && sid.equals("admin")) {
            Page page = new Page();
            page.setSearchType(type);
            page.setSearchKeyword(keyword);
            int total = voteService.totalCountForAdmin(page);

            page.makeBlock(curPage, total);
            page.makeLastPageNum(total);
            page.makePostStart(curPage, total);

            List<Vote> voteList = voteService.voteAllListForAdmin(page);

            model.addAttribute("adminNum", 4);
            model.addAttribute("type", type);
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
            model.addAttribute("curPage", curPage);
            model.addAttribute("voteList", voteList);

            return "/admin/voteList";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "getVote.do", method = RequestMethod.GET)
    public String getVoteDetail(@RequestParam int vno, Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {
            model.addAttribute("adminNum", 4);
            if(vno != 0) {
                Vote vote = voteService.voteDetail(vno);
                model.addAttribute("vote", vote);

                if(!vote.isUseYn()) {
                    List<VoteList> voteAnswerList = voteService.voteAnswerList(vno);
                    model.addAttribute("voteAnswerList", voteAnswerList);
                } else {
                    int cnt = voteService.voteCountCnt(vno);
                    model.addAttribute("cnt", cnt);

                    VoteCountVo getMaxLno = voteService.voteMaxCountList(vno);
                    model.addAttribute("getMaxLno", getMaxLno);

                    List<VoteCountVo> voteCountList = voteService.voteCountList(vno);
                    model.addAttribute("voteCountList", voteCountList);
                }

                return "/admin/voteDetail";
            } else {
                return "redirect:/admin/VoteMemberListAdmin.do";
            }
        } else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "voteAdd.do", method = RequestMethod.GET)
    public String voteInsert(Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {
            model.addAttribute("adminNum", 4);
            return "/admin/voteInsert";
        } else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "voteEdit.do", method = RequestMethod.GET)
    public String voteUpdate(@RequestParam int vno, Model model) throws Exception {

        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {
            Vote vote = voteService.voteDetail(vno);
            model.addAttribute("vote", vote);
            model.addAttribute("adminNum", 4);
            return "/admin/voteUpdate";
        } else {
            return "redirect:/";
        }

    }


}