package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.service.NoticeService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/notice/*")
public class NoticeCtrl {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "noticeList", method = RequestMethod.GET)
    public String noticeList(HttpServletRequest request, Model model) throws Exception{
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
                total = noticeService.noticeTitleCount(page);
                break;
            case "content":
                total = noticeService.noticeContentCount(page);
                break;
            default:
                total = noticeService.noticeCount();
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);


        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<Notice> noticeList;
        switch (type){
            case "title":
                noticeList = noticeService.noticeTitleList(page);
                break;
            case "content":
                noticeList = noticeService.noticeContentList(page);
                break;
            default:
                noticeList = noticeService.noticePageList(page);
        }

        model.addAttribute("noticeList", noticeList);
        return "/community/notice/noticeList";
    }

    @GetMapping("noticeGet")
    public String noticeGet(HttpServletRequest request, Model model) throws Exception{
        int noticeNo = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(noticeNo);
        model.addAttribute("notice", notice);
       return "/community/notice/noticeGet";

    }
    @GetMapping("noticeInsert")
    public String noticeInsert(HttpServletRequest request, Model model) throws Exception{
        return "/community/notice/noticeInsert";
    }
    @PostMapping("noticeInsert")
    public String noticeInsertpro(HttpServletRequest request, Model model) throws Exception{
        Notice notice = new Notice();
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeInsert(notice);
        return "redirect: noticeList";
    }
    @GetMapping("noticeUpdate")
    public String noticeUpdate(HttpServletRequest request, Model model) throws Exception{
        int noticeNo = Integer.parseInt(request.getParameter("no"));
        Notice notice = noticeService.noticeGet(noticeNo);
        model.addAttribute("notice", notice);
        return "/community/notice/noticeUpdate";
    }

    @PostMapping("noticeUpdate")
    public String noticeUpdatepro(HttpServletRequest request, Model model) throws Exception{
        int noticeNo = Integer.parseInt(request.getParameter("no"));
        Notice notice = new Notice();
        notice.setNoticeNo(noticeNo);
        notice.setTitle(request.getParameter("title"));
        notice.setContent(request.getParameter("content"));
        noticeService.noticeUpdate(notice);
        return "redirect: noticeList";
    }

    @GetMapping("noticeDelete")
    public String noticeDelete(HttpServletRequest request, Model model) throws Exception{
        int noticeNo = Integer.parseInt(request.getParameter("no"));
        noticeService.noticeDelete(noticeNo);
        return "redirect: noticeList";
    }

}
