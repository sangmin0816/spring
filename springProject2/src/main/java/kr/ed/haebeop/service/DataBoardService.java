package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.DataBoard;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface DataBoardService {
    // DataBoard
    public List<DataBoard> dataBoardList(Page page) throws Exception;
    public DataBoard dataBoardGet(int bno) throws Exception;
    public int dataBoardCount(Page page) throws Exception;
    public void dataBoardInsert(DataBoard dataBoard) throws Exception;
    public void dataBoardUpdate(DataBoard dataBoard) throws Exception;
    public void dataBoardDelete(int bno) throws Exception;

    // QnaBoard


}