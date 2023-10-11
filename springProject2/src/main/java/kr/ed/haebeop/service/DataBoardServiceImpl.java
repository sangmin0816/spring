package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.DataBoard;
import kr.ed.haebeop.persistence.DataBoardMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataBoardServiceImpl implements DataBoardService {

    @Autowired
    private DataBoardMapper dataBoardRepo;

    @Override
    public List<DataBoard> dataBoardList(Page page) throws Exception {
        return dataBoardRepo.dataBoardList(page);
    }

    @Override
    public DataBoard dataBoardGet(int bno) throws Exception {
        return dataBoardRepo.dataBoardGet(bno);
    }

    @Override
    public int dataBoardCount(Page page) throws Exception {
        return dataBoardRepo.dataBoardCount(page);
    }

    @Transactional
    @Override
    public void dataBoardInsert(DataBoard dataBoard) throws Exception {
        dataBoardRepo.dataBoardInsert(dataBoard);

    }

    @Override
    public void dataBoardUpdate(DataBoard dataBoard) throws Exception {
        dataBoardRepo.dataBoardUpdate(dataBoard);
    }

    @Override
    public void dataBoardDelete(int bno) throws Exception {
        dataBoardRepo.dataBoardDelete(bno);
    }
    

}
