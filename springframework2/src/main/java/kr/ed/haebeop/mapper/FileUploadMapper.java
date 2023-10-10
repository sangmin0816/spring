package kr.ed.haebeop.mapper;

import kr.ed.haebeop.domain.FileDTO;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

// Mapper annotation을 하는 경우, 따로 applicationContext.xml나 ApplicationConfig.java에 bean을 등록하지 않아도 된다.
@Mapper
public interface FileUploadMapper {
    // ibatis Annotation을 사용하는 경우 따로 mapper.xml 파일을 만들지 않아도 된다.
    // ibatis Annotation을 사용하지 않는 경우 mapper.xml에 함수명과 동일한 이름의 sql문을 작성해야 한다.
    @Select("SELECT * from files")
    public List<FileDTO> fileList();

    @Select("SELECT * from files WHERE fno=#{fno}")
    public FileDTO fileGet(int fno);

    @Insert("INSERT INTO files (fileName, saveName, fileType, saveFolder) VALUES (#{fileName}, #{saveName}, #{fileType}, #{saveFolder}")
    public void fileInsert(FileDTO fileDTO);

    @Delete("DELETE from files where fno=#{fno}")
    public void fileDelete(int fno);
}
