package kr.ed.haebeop.util;

import lombok.Data;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Data
public class Page {
    private int pageCount = 5;
    private int blockStartNum = 0;
    private int blockLastNum = 0;
    private int lastPageNum = 0;
    private int curPageNum = 1;
    private int postCount = 10;
    private int postStart;
    private int pageBlockNum = 1;
    private int totalBlockNum = 1;
    private int totalPageCount = 1;
    private String searchType = "";
    private String searchKeyword = "";

    private int courseNo; // course의 세부 게시판에서 사용


    // 전체 페이지 개수 구하는 메소드
    public void makePostStart(int curPage, int total) {

        this.postStart = (curPage - 1) * this.postCount;
        this.pageBlockNum = (int) Math.floor(curPage / pageCount);

        int comp = pageCount * postCount;
        if (total % comp == 0) {
            this.totalBlockNum = (int) Math.floor(total / comp);
        } else {
            this.totalBlockNum = (int) Math.floor(total / comp) + 1;
        }
        if (total % postCount == 0) {
            totalPageCount = (int) Math.floor(total / postCount);
        } else {
            totalPageCount = (int) Math.floor(total / postCount) + 1;
        }
    }


    // block을 생성
    // 현재 페이지가 속한 block의 시작 번호, 끝 번호를 계산하는 메소드
    public void makeBlock(int curPage, int total) {
        int blockNum = 0;

        blockNum = (int) Math.floor((curPage - 1) / pageCount);
        blockStartNum = (pageCount * blockNum) + 1;

        int comp = 0;
        if (total % postCount == 0) {
            comp = (int) Math.floor(total / postCount);
        } else {
            comp = (int) Math.floor(total / postCount) + 1;
        }
        blockLastNum = blockStartNum + (pageCount - 1);
        if (blockLastNum >= comp) {
            blockLastNum = comp;
        }
    }

    // 총 페이지의 마지막 번호 구하는 메소드
    public void makeLastPageNum(int total) {
        if (total % pageCount == 0) {
            lastPageNum = (int) Math.floor(total / pageCount);
        } else {
            lastPageNum = (int) Math.floor(total / pageCount) + 1;
        }
    }

    public static Page pageStart(HttpServletRequest request, Model model){
        Page page = new Page();

        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        page.setSearchType(type);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("curPage", curPage);
        page.setSearchKeyword(keyword);
        page.setCurPageNum(curPage);

        return page;
    }

    public static Page pageEnd(HttpServletRequest request, Model model, Page page, int total){
        int curPage = page.getCurPageNum();
        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("page", page);

        return page;
    }
}
