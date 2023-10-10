package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreeMapper {
    public List<Free> freeList(Page page);
    public List<Free> freeListForMain();
    public void freeCountUp(int fno);
    public int totalCount(Page page);
    public Free freeDetail(int fno);
    public void freeInsert(Free dto);
    public void freeUpdate(Free dto);
    public void freeDelete(int fno);
}
