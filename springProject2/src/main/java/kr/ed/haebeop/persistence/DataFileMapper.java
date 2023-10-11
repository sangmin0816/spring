package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.DataFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataFileMapper {
    // DataFile
    public List<DataFile> dataFileList();
    public List<DataFile> dataFileBoardList(DataFile dataFile);
    public List<DataFile> dataFileInsertList();
    public DataFile dataFileGet(int fno);
    public int dataFileCount();
    public void dataFileInsert(DataFile dataFile);
    public void dataFileUpdate(DataFile dataFile);
    public void dataFileDelete(int fno);
}
