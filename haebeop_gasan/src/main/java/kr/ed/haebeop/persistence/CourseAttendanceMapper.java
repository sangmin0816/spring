package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.CourseAttendance;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseAttendanceMapper {
    @Select("SELECT * FROM courseAttendance")
    public List<CourseAttendance> courseAttendanceList();

    @Select("SELECT * FROM courseAttendance WHERE attendanceNo=#{attendanceNo}")
    public CourseAttendance courseAttendanceGet(int attendanceNo);

    @Select("SELECT COUNT(*) FROM courseAttendance WHERE courseNo=#{courseNo}")
    public int courseAttendanceCount(int courseNo);

    @Insert("INSERT INTO courseAttendance(courseNo, id, status) VALUES(#{courseNo}, #{id}, #{status})")
    public void courseAttendanceInsert(CourseAttendance courseAttendance);

    @Update("UPDATE courseAttendance SET attdate=#{attdate}, status=#{status} WHERE attendanceNo=#{attendanceNo}")
    public void courseAttendanceUpdate(CourseAttendance courseAttendance);

    @Delete("DELETE FROM courseAttendance WHERE attendanceNo=#{attendanceNo}")
    public void courseAttendanceDelete(int attendanceNo);



    @Select("SELECT * FROM courseAttendance WHERE courseNo=#{courseNo} order by attendanceNo desc LIMIT #{postStart}, #{postCount}")
    public List<CourseAttendance> courseAttendancePageList(Page page);

    @Select("SELECT * FROM courseAttendance WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%') order by attendanceNo desc LIMIT #{postStart}, #{postCount}")
    public List<CourseAttendance> courseAttendanceIdList(Page page);

    @Select("SELECT COUNT(*) FROM courseAttendance WHERE courseNo=#{courseNo} AND id LIKE CONCAT('%', #{searchKeyword}, '%')")
    public int courseAttendanceIdCount(Page page);
}
