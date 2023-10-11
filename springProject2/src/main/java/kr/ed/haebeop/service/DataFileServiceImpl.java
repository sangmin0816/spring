package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.DataFile;

import kr.ed.haebeop.persistence.DataFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataFileServiceImpl implements DataFileService {

    @Autowired
    private DataFileMapper dataFileRepo;

    @Override
    public List<DataFile> dataFileList() throws Exception {
        return dataFileRepo.dataFileList();
    }

    @Override
    public List<DataFile> dataFileBoardList(DataFile dataFile) throws Exception {
        return dataFileRepo.dataFileBoardList(dataFile);
    }

    @Override
    public DataFile dataFileGet(int fno) throws Exception {
        return dataFileRepo.dataFileGet(fno);
    }

    @Override
    public int dataFileCount() throws Exception {
        return dataFileRepo.dataFileCount();
    }

    @Override
    public void dataFileInsert(DataFile dataFile) throws Exception {
        dataFileRepo.dataFileInsert(dataFile);
    }

    @Override
    public void dataFileUpdate(DataFile dataFile) throws Exception {
        dataFileRepo.dataFileUpdate(dataFile);
    }

    @Override
    public void dataFileDelete(int fno) throws Exception {
        dataFileRepo.dataFileDelete(fno);
    }
}
