package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.util.PageAcademy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    public List<Academy> academyList(PageAcademy page);
    public List<Academy> academyAdminList(String id);
    public Academy academyGet(int ano);
    public int academyCount(PageAcademy page);
}
