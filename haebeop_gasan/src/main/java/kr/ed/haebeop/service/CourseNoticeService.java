package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseNotice;
import kr.ed.haebeop.util.Page;


import java.util.List;


public interface CourseNoticeService {
    public List<CourseNotice> courseNoticeList();
    public CourseNotice courseNoticeGet(int noticeNo);
    public int courseNoticeCount(int courseNo);
    public void courseNoticeInsert(CourseNotice courseNotice);
    public void courseNoticeUpdate(CourseNotice courseNotice);
    public void courseNoticeDelete(int noticeNo);


    public void courseNoticeVisit(int noticeNo);
    public List<CourseNotice> courseNoticePageList(Page page);
    public List<CourseNotice> courseNoticeTitleList(Page page);
    public List<CourseNotice> courseNoticeContentList(Page page);
    public int courseNoticeTitleCount(Page page);
    public int courseNoticeContentCount(Page page);
}
