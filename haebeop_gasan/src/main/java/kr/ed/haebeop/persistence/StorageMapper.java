package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Storage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StorageMapper {
    @Select("SELECT * FROM storage")
    public List<Storage> storageList();

    @Select("SELECT * FROM storage WHERE fileNo=#{fileNo}")
    public Storage storageGet(int fileNo);

    @Select("SELECT COUNT(*) FROM storage")
    public int storageCount();

    @Insert("INSERT INTO storage(originName, saveName, savePath, boardName, boardNo) VALUES(#{originName}, #{saveName}, #{savePath}, #{boardName}, #{boardNo})")
    public void storageInsert(Storage storage);

    @Update("UPDATE storage SET originName=#{originName}, saveName=#{saveName}, savePath=#{savePath}, boardName=#{boardName}, boardNo=#{boardNo} WHERE fileNo=#{fileNo}")
    public void storageUpdate(Storage storage);

    @Delete("DELETE FROM storage WHERE fileNo=#{fileNo}")
    public void storageDelete(int fileNo);



    @Select("SELECT storageNo FROM storage ORDER BY regdate DESC LIMIT 1")
    public int storageRecentNo();

    @Select("SELECT * FROM storage where boardName=#{boardName} AND boardNo=#{boardNo}")
    public List<Storage> storageBoardList(Storage storage);

    @Select("SELECT * FROM storage where boardName=#{boardName} AND boardNo=#{boardNo}")
    public Storage storageBoardGet(Storage storage);
}
