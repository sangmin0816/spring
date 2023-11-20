package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FreeMapper {
    @Select("SELECT * FROM free")
    public List<Free> freeList();

    @Select("SELECT * FROM free WHERE freeNo=#{freeNo}")
    public Free freeGet(int freeNo);

    @Select("SELECT COUNT(*) FROM free")
    public int freeCount();

    @Insert("INSERT INTO free(title, content, id) VALUES(#{title}, #{content}, #{id})")
    public void freeInsert(Free free);

    @Update("UPDATE free SET title=#{title}, content=#{content} WHERE freeNo=#{freeNo}")
    public void freeUpdate(Free free);

    @Delete("DELETE FROM free WHERE freeNo=#{freeNo}")
    public void freeDelete(int freeNo);


    @Update("UPDATE free SET visited=visited+1 WHERE freeNo=#{freeNo}")
    public void freeVisit(int freeNo);

    @Select("SELECT * FROM free order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Free> freePageList(Page page);

    @Select("SELECT * FROM free WHERE title LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Free> freeTitleList(Page page);

    @Select("SELECT * FROM free WHERE content LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Free> freeContentList(Page page);

    @Select("SELECT * FROM free WHERE id LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Free> freeIdList(Page page);

    @Select("SELECT COUNT(*) FROM free WHERE title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int freeTitleCount(Page page);

    @Select("SELECT COUNT(*) FROM free WHERE content LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int freeContentCount(Page page);

    @Select("SELECT COUNT(*) FROM free WHERE id LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int freeIdCount(Page page);
}
