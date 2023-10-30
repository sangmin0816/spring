package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.util.Page;


import java.util.List;


public interface FreeService {
    public List<Free> freeList();
    public Free freeGet(int freeNo);
    public int freeCount();
    public void freeInsert(Free free);
    public void freeUpdate(Free free);
    public void freeDelete(int freeNo);


    public void freeVisit(int freeNo);
    public List<Free> freePageList(Page page);
    public List<Free> freeTitleList(Page page);
    public List<Free> freeContentList(Page page);
    public List<Free> freeIdList(Page page);
    public int freeTitleCount(Page page);
    public int freeContentCount(Page page);
    public int freeIdCount(Page page);
}
