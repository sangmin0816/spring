package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.CourseMaterials;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMaterialsMapper {
    @Select("SELECT * FROM courseMaterials")
    public List<CourseMaterials> courseMaterialsList();

    @Select("SELECT * FROM courseMaterials WHERE materialNo=#{materialNo}")
    public CourseMaterials courseMaterialsGet(int materialNo);

    @Select("SELECT COUNT(*) FROM courseMaterials WHERE courseNo=#{courseNo}")
    public int courseMaterialsCount(int courseNo);

    @Insert("INSERT INTO courseMaterials(courseNo, title, content, id, hasFile) VALUES(#{courseNo}, #{title}, #{content}, #{id}, #{hasFile})")
    public void courseMaterialsInsert(CourseMaterials courseMaterials);

    @Update("UPDATE courseMaterials SET title=#{title}, content=#{content}, hasFile=#{hasFile} WHERE materialNo=#{materialNo}")
    public void courseMaterialsUpdate(CourseMaterials courseMaterials);

    @Delete("DELETE FROM courseMaterials WHERE materialNo=#{materialNo}")
    public void courseMaterialsDelete(int materialNo);



    @Select("SELECT * FROM courseMaterials ORDER BY materialNo DESC LIMIT 1")
    public CourseMaterials courseMaterialsGetLast();
    @Update("UPDATE courseMaterials SET visited=visited+1 WHERE materialNo=#{materialNo}")
    public void courseMaterialsVisit(int materialNo);

    @Select("SELECT * FROM courseMaterials WHERE courseNo=#{courseNo} order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseMaterials> courseMaterialsPageList(Page page);

    @Select("SELECT * FROM courseMaterials WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseMaterials> courseMaterialsTitleList(Page page);

    @Select("SELECT * FROM courseMaterials WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseMaterials> courseMaterialsContentList(Page page);

    @Select("SELECT * FROM courseMaterials WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseMaterials> courseMaterialsIdList(Page page);

    @Select("SELECT COUNT(*) FROM courseMaterials WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseMaterialsTitleCount(Page page);

    @Select("SELECT COUNT(*) FROM courseMaterials WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseMaterialsContentCount(Page page);

    @Select("SELECT COUNT(*) FROM courseMaterials WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseMaterialsIdCount(Page page);
}
