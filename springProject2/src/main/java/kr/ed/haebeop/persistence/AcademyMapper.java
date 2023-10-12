package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Academy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcademyMapper {
    public Academy academyGet(int ano);
}
