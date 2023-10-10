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
    private NoticeMapper noticeRepo;

    @Override
    public List<Notice> noticeList() throws Exception {
        return noticeRepo.noticeList();
    }

    @Override
    public List<Notice> noticeListForMain() throws Exception {
        return noticeRepo.noticeListForMain();
    }

    @Override
    public Notice noticeGet(int no) throws Exception {
        return noticeRepo.noticeGet(no);
    }

    @Override
    public void noticeInsert(Notice notice) throws Exception {
        noticeRepo.noticeInsert(notice);
    }

    @Override
    public void noticeUpdate(Notice notice) throws Exception {
        noticeRepo.noticeUpdate(notice);
    }

    @Override
    public void noticeDelete(int no) throws Exception {
        noticeRepo.noticeDelete(no);

    }

    @Override
    public List<Notice> noticeListPro(Page page) throws Exception {
        return noticeRepo.noticeListPro(page);
    }

    @Override
    public int noticeCount(Page page) throws Exception {
        return noticeRepo.noticeCount(page);
    }
}
