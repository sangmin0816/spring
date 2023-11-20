package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseNotice;
import kr.ed.haebeop.persistence.CourseNoticeMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseNoticeServiceImpl implements CourseNoticeService{
    @Autowired
    CourseNoticeMapper courseNoticeMapper;

    @Override
    public List<CourseNotice> courseNoticeList() {
        return courseNoticeMapper.courseNoticeList();
    }

    @Override
    public CourseNotice courseNoticeGet(int courseNoticeNo) {
        courseNoticeMapper.courseNoticeVisit(courseNoticeNo);
        return courseNoticeMapper.courseNoticeGet(courseNoticeNo);
    }

    @Override
    public void courseNoticeInsert(CourseNotice courseNotice) {
        courseNoticeMapper.courseNoticeInsert(courseNotice);
    }

    @Override
    public void courseNoticeDelete(int courseNoticeNo) {
        courseNoticeMapper.courseNoticeDelete(courseNoticeNo);
    }

    @Override
    public void courseNoticeUpdate(CourseNotice courseNotice) {
        courseNoticeMapper.courseNoticeUpdate(courseNotice);
    }

    @Override
    public List<CourseNotice> courseNoticePageList(Page page) {
        return courseNoticeMapper.courseNoticePageList(page);
    }

    @Override
    public int courseNoticeCount(int courseNo) {
        return courseNoticeMapper.courseNoticeCount(courseNo);
    }

    @Override
    public void courseNoticeVisit(int materialNo) {
        courseNoticeMapper.courseNoticeVisit(materialNo);
    }

    @Override
    public List<CourseNotice> courseNoticeTitleList(Page page) {
        return courseNoticeMapper.courseNoticeTitleList(page);
    }

    @Override
    public List<CourseNotice> courseNoticeContentList(Page page) {
        return courseNoticeMapper.courseNoticeContentList(page);
    }

    @Override
    public int courseNoticeTitleCount(Page page) {
        return courseNoticeMapper.courseNoticeTitleCount(page);
    }

    @Override
    public int courseNoticeContentCount(Page page) {
        return courseNoticeMapper.courseNoticeContentCount(page);
    }
}
