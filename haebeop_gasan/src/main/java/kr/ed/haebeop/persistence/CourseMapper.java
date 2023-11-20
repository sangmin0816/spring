package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("SELECT * FROM course")
    public List<Course> courseList();

    @Select("SELECT * FROM course WHERE courseNo=#{courseNo}")
    public Course courseGet(int courseNo);

    @Select("SELECT COUNT(*) FROM course")
    public int courseCount();

    @Insert("INSERT INTO course(teacherNo, categoryNo, title, content, videoFile, isOngoing, price, capacity) VALUES(#{teacherNo}, #{categoryNo}, #{title}, #{content}, #{videoFile}, #{isOngoing}, #{price}, #{capacity})")
    public void courseInsert(Course course);

    @Update("UPDATE course SET teacherNo=#{teacherNo}, categoryNo=#{categoryNo}, title=#{title}, content=#{content}, videoFile=#{videoFile}, isOngoing=#{isOngoing}, price=#{price}, capacity=#{capacity} WHERE courseNo=#{courseNo}")
    public void courseUpdate(Course course);

    @Delete("DELETE FROM course WHERE courseNo=#{courseNo}")
    public void courseDelete(int courseNo);


    @Select("SELECT * FROM course WHERE isOngoing=TRUE")
    public List<Course> courseOnList();

    @Select("SELECT * FROM course WHERE teacherNo=#{teacherNo}")
    public List<Course> courseTeacherList(int teacherNo);


    @Select("SELECT * FROM course order by courseNo desc LIMIT #{postStart}, #{postCount}")
    public List<Course> coursePageList(Page page);
    
    @Select("SELECT * FROM course WHERE title LIKE CONCAT('%', #{searchKeyword}, '%') order by courseNo desc LIMIT #{postStart}, #{postCount}")
    public List<Course> courseTitleList(Page page);
    @Select("SELECT COUNT(*) FROM course WHERE title LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseTitleCount(Page page);
}
