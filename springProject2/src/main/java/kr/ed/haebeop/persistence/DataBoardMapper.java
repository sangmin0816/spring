package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.DataBoard;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataBoardMapper {

    public List<DataBoard> dataBoardList(Page page);
    public DataBoard dataBoardGet(int bno);
    public DataBoard dataBoardGetLast();
    public int dataBoardCount(Page page);
    public int dataBoardCountUp(int bno);
    public void dataBoardInsert(DataBoard dataBoard);
    public void dataBoardUpdate(DataBoard dataBoard);
    public void dataBoardDelete(int bno);
}

