package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Unavailable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnavailableMapper {
    public List<Unavailable> unavailableAcademyMonth(Unavailable unavailable);
    public void unavailableInsert(Unavailable unavailable);
    public void unavailableDelete(Unavailable unavailable);
}
