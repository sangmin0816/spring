package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Qna;
import kr.ed.haebeop.service.QnaService;
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
@RequestMapping("/qna/*")
public class QnaCtrl {
    @Autowired
    private QnaService qnaService;

    // Qna
    @GetMapping("qnaList")
    public String qnaList(HttpServletRequest request, Model model) throws Exception {
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);
        int total = qnaService.qnaCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<Qna> qnaList = qnaService.qnaList(page);
        model.addAttribute("qnaList", qnaList);
        return "/qna/qnaList";
    }

    @GetMapping("qnaGet.do")
    public String qnaGet(HttpServletRequest request, Model model) throws Exception {
        int qno = Integer.parseInt(request.getParameter("qno"));
        Qna dto = qnaService.qnaGet(qno);
        model.addAttribute("qna", dto);
        return "/qna/qnaGet";
    }

    @GetMapping("qnaInsert.do")
    public String qnaInsertForm(HttpServletRequest request, Model model) throws Exception {
        int lev = Integer.parseInt(request.getParameter("lev"));
        int par = Integer.parseInt(request.getParameter("par"));
        model.addAttribute("lev", lev);
        model.addAttribute("par", par);
        return "/qna/qnaInsert";
    }

    @PostMapping("qnaInsert.do")
    public String qnaInsert(HttpServletRequest request) throws Exception {
        Qna dto = new Qna();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setAuthor(request.getParameter("author"));
        dto.setLev(Integer.parseInt(request.getParameter("lev")));
        dto.setPar(Integer.parseInt(request.getParameter("par")));

        qnaService.qnaInsert(dto);
        return "redirect:qnaList.do";
    }

    @GetMapping("qnaDelete.do")
    public String qnaDelete(HttpServletRequest request) throws Exception {
        int qno = Integer.parseInt(request.getParameter("qno"));
        qnaService.qnaDelete(qno);

        return "redirect:qnaList.do";
    }

    @GetMapping("qnaUpdate.do")
    public String qnaUpdateForm(HttpServletRequest request, Model model) throws Exception {
        int qno = Integer.parseInt(request.getParameter("qno"));
        Qna dto = qnaService.qnaGet(qno);
        model.addAttribute("qna", dto);
        return "/qna/qnaUpdate";
    }

    @PostMapping("qnaUpdate.do")
    public String qnaUpdate(HttpServletRequest request) throws Exception {
        Qna dto = new Qna();
        dto.setQno(Integer.parseInt(request.getParameter("qno")));
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        qnaService.qnaUpdate(dto);

        return "redirect:qnaList.do";
    }
}
