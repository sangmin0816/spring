package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.persistence.NoticeMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> noticeList() {
        return noticeMapper.noticeList();
    }

    @Override
    public Notice noticeGet(int noticeNo) {
        noticeMapper.noticeVisit(noticeNo);
        return noticeMapper.noticeGet(noticeNo);
    }

    @Override
    public void noticeInsert(Notice notice) {
        noticeMapper.noticeInsert(notice);
    }

    @Override
    public void noticeDelete(int noticeNo) {
        noticeMapper.noticeDelete(noticeNo);
    }

    @Override
    public void noticeUpdate(Notice notice) {
        noticeMapper.noticeUpdate(notice);
    }

    @Override
    public List<Notice> noticePageList(Page page) {
        return noticeMapper.noticePageList(page);
    }

    @Override
    public void noticeVisit(int materialNo) {
        noticeMapper.noticeVisit(materialNo);
    }

    @Override
    public List<Notice> noticeTitleList(Page page) {
        return noticeMapper.noticeTitleList(page);
    }

    @Override
    public List<Notice> noticeContentList(Page page) {
        return noticeMapper.noticeContentList(page);
    }

    @Override
    public int noticeTitleCount(Page page) {
        return noticeMapper.noticeTitleCount(page);
    }

    @Override
    public int noticeContentCount(Page page) {
        return noticeMapper.noticeContentCount(page);
    }

    @Override
    public int noticeCount() {
        return noticeMapper.noticeCount();
    }
}
