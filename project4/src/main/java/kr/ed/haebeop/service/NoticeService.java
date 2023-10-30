package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.util.Page;


import java.util.List;


public interface NoticeService {
    public List<Notice> noticeList();
    public Notice noticeGet(int noticeNo);
    public int noticeCount();
    public void noticeInsert(Notice notice);
    public void noticeUpdate(Notice notice);
    public void noticeDelete(int noticeNo);


    public void noticeVisit(int noticeNo);
    public List<Notice> noticePageList(Page page);
    public List<Notice> noticeTitleList(Page page);
    public List<Notice> noticeContentList(Page page);
    public int noticeTitleCount(Page page);
    public int noticeContentCount(Page page);
}
