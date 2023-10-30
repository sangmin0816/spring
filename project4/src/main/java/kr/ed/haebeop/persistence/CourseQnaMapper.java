package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.CourseQna;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseQnaMapper {
    @Select("SELECT * FROM courseQna")
    public List<CourseQna> courseQnaList();

    @Select("SELECT * FROM courseQna WHERE qnaNo=#{qnaNo}")
    public CourseQna courseQnaGet(int qnaNo);

    @Select("SELECT COUNT(*) FROM courseQna WHERE courseNo=#{courseNo}")
    public int courseQnaCount(int courseNo);

    @Insert("INSERT INTO courseQna(courseNo, title, content, id, lev, par) VALUES(#{courseNo}, #{title}, #{content}, #{id}, #{lev}, #{par})")
    public void courseQnaInsert(CourseQna courseQna);

    @Update("UPDATE courseQna SET title=#{title}, content=#{content} WHERE qnaNo=#{qnaNo}")
    public void courseQnaUpdate(CourseQna courseQna);

    @Delete("DELETE FROM courseQna WHERE qnaNo=#{qnaNo}")
    public void courseQnaDelete(int qnaNo);


    @Update("UPDATE courseQna SET par=qnaNo WHERE lev=0 AND par=0")
    public void courseQnaParUpdate();

    @Update("UPDATE courseQna SET visited=visited+1 WHERE qnaNo=#{qnaNo}")
    public void courseQnaVisit(int qnaNo);

    @Select("SELECT * FROM courseQna WHERE courseNo=#{courseNo} order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseQna> courseQnaPageList(Page page);

    @Select("SELECT * FROM courseQna WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseQna> courseQnaTitleList(Page page);

    @Select("SELECT * FROM courseQna WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseQna> courseQnaContentList(Page page);

    @Select("SELECT * FROM courseQna WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseQna> courseQnaIdList(Page page);

    @Select("SELECT COUNT(*) FROM courseQna WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseQnaTitleCount(Page page);

    @Select("SELECT COUNT(*) FROM courseQna WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseQnaContentCount(Page page);

    @Select("SELECT COUNT(*) FROM courseQna WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseQnaIdCount(Page page);
}
