package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.CourseNotice;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseNoticeMapper {
    @Select("SELECT * FROM courseNotice")
    public List<CourseNotice> courseNoticeList();

    @Select("SELECT * FROM courseNotice WHERE noticeNo=#{noticeNo}")
    public CourseNotice courseNoticeGet(int noticeNo);

    @Select("SELECT COUNT(*) FROM courseNotice where courseNo=#{courseNo}")
    public int courseNoticeCount(int courseNo);

    @Insert("INSERT INTO courseNotice(courseNo, title, content) VALUES(#{courseNo}, #{title}, #{content})")
    public void courseNoticeInsert(CourseNotice courseNotice);

    @Update("UPDATE courseNotice SET title=#{title}, content=#{content} WHERE noticeNo=#{noticeNo}")
    public void courseNoticeUpdate(CourseNotice courseNotice);

    @Delete("DELETE FROM courseNotice WHERE noticeNo=#{noticeNo}")
    public void courseNoticeDelete(int noticeNo);


    @Update("UPDATE courseNotice SET visited=visited+1 WHERE noticeNo=#{noticeNo}")
    public void courseNoticeVisit(int noticeNo);

    @Select("SELECT * FROM courseNotice WHERE courseNo=#{courseNo} order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseNotice> courseNoticePageList(Page page);

    @Select("SELECT * FROM courseNotice WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseNotice> courseNoticeTitleList(Page page);

    @Select("SELECT * FROM courseNotice WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<CourseNotice> courseNoticeContentList(Page page);


    @Select("SELECT COUNT(*) FROM courseNotice WHERE courseNo=#{courseNo} AND title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseNoticeTitleCount(Page page);

    @Select("SELECT COUNT(*) FROM courseNotice WHERE courseNo=#{courseNo} AND content LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseNoticeContentCount(Page page);
}
