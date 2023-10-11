package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface FreeService {
    public List<Free> freeList(Page page) throws Exception;
    public List<Free> freeListForMain() throws Exception;
    public int totalCount(Page page) throws Exception;
    public Free freeDetail(int fno) throws Exception;
    public void freeInsert(Free dto) throws Exception;
    public void freeUpdate(Free dto) throws Exception;
    public void freeDelete(int fno) throws Exception;
}
