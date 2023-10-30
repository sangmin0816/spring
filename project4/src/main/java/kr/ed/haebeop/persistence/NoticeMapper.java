package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {
    @Select("SELECT * FROM notice")
    public List<Notice> noticeList();

    @Select("SELECT * FROM notice WHERE noticeNo=#{noticeNo}")
    public Notice noticeGet(int noticeNo);

    @Select("SELECT COUNT(*) FROM notice")
    public int noticeCount();

    @Insert("INSERT INTO notice(title, content) VALUES(#{title}, #{content})")
    public void noticeInsert(Notice notice);

    @Update("UPDATE notice SET title=#{title}, content=#{content} WHERE noticeNo=#{noticeNo}")
    public void noticeUpdate(Notice notice);

    @Delete("DELETE FROM notice WHERE noticeNo=#{noticeNo}")
    public void noticeDelete(int noticeNo);


    @Update("UPDATE notice SET visited=visited+1 WHERE noticeNo=#{noticeNo}")
    public void noticeVisit(int noticeNo);

    @Select("SELECT * FROM notice order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Notice> noticePageList(Page page);

    @Select("SELECT * FROM notice WHERE title LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Notice> noticeTitleList(Page page);

    @Select("SELECT * FROM notice WHERE content LIKE CONCAT('%', #{searchKeyword}, '%') order by regdate desc LIMIT #{postStart}, #{postCount}")
    public List<Notice> noticeContentList(Page page);


    @Select("SELECT COUNT(*) FROM notice WHERE title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int noticeTitleCount(Page page);

    @Select("SELECT COUNT(*) FROM notice WHERE content LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int noticeContentCount(Page page);
}
