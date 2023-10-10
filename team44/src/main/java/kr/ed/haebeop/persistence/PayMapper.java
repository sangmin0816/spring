package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    public List<Pay> payAllList();
    public List<Pay> payList(String memId);
    public Pay payGet(int payNo);
    public void payInsert(Pay pay);
    public void payUpdate(Pay pay);
    public void payDelete(int payNo);
}
