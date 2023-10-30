package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.persistence.FreeMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeServiceImpl implements FreeService{
    @Autowired
    FreeMapper freeMapper;

    @Override
    public List<Free> freeList() {
        return freeMapper.freeList();
    }

    @Override
    public Free freeGet(int freeNo) {
        freeMapper.freeVisit(freeNo);
        return freeMapper.freeGet(freeNo);
    }

    @Override
    public void freeInsert(Free free) {
        freeMapper.freeInsert(free);
    }

    @Override
    public void freeDelete(int freeNo) {
        freeMapper.freeDelete(freeNo);
    }

    @Override
    public void freeUpdate(Free free) {
        freeMapper.freeUpdate(free);
    }

    @Override
    public List<Free> freePageList(Page page) {
        return freeMapper.freePageList(page);
    }

    @Override
    public List<Free> freeIdList(Page page) {
        return freeMapper.freeIdList(page);
    }

    @Override
    public int freeIdCount(Page page) {
        return freeMapper.freeIdCount(page);
    }

    @Override
    public void freeVisit(int materialNo) {
        freeMapper.freeVisit(materialNo);
    }

    @Override
    public List<Free> freeTitleList(Page page) {
        return freeMapper.freeTitleList(page);
    }

    @Override
    public List<Free> freeContentList(Page page) {
        return freeMapper.freeContentList(page);
    }

    @Override
    public int freeTitleCount(Page page) {
        return freeMapper.freeTitleCount(page);
    }

    @Override
    public int freeContentCount(Page page) {
        return freeMapper.freeContentCount(page);
    }

    @Override
    public int freeCount() {
        return freeMapper.freeCount();
    }
}
