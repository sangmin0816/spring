package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.persistence.FreeMapper;

import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeServiceImpl implements FreeService {

    @Autowired
    private FreeMapper freeRepo;

    @Override
    public List<Free> freeList(Page page) throws Exception {
        return freeRepo.freeList(page);
    }

    @Override
    public List<Free> freeListForMain() throws Exception {
        return freeRepo.freeListForMain();
    }

    @Override
    public int totalCount(Page page) throws Exception {
        return freeRepo.totalCount(page);
    }

    @Override
    public Free freeDetail(int fno) throws Exception {
        return freeRepo.freeDetail(fno);
    }

    @Override
    public void freeInsert(Free dto) throws Exception {
        freeRepo.freeInsert(dto);
    }

    @Override
    public void freeDelete(int fno) throws Exception {
        freeRepo.freeDelete(fno);
    }

    @Override
    public void freeUpdate(Free dto) throws Exception {
        freeRepo.freeUpdate(dto);
    }
}