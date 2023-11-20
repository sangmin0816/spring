package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("SELECT * FROM teacher")
    public List<Teacher> teacherList();

    @Select("SELECT * FROM teacher WHERE teacherNo=#{teacherNo}")
    public Teacher teacherGet(int teacherNo);

    @Select("SELECT COUNT(*) FROM teacher")
    public int teacherCount();

    @Insert("INSERT INTO teacher(id, name, email, tel, imageFile, career) VALUES(#{id},#{name}, #{email}, #{tel}, #{imageFile}, #{career})")
    public void teacherInsert(Teacher teacher);

    @Update("UPDATE teacher SET email=#{email}, tel=#{tel}, imageFile=#{imageFile}, career=#{career} WHERE teacherNo=#{teacherNo}")
    public void teacherUpdate(Teacher teacher);

    @Delete("DELETE FROM teacher WHERE teacherNo=#{teacherNo}")
    public void teacherDelete(int teacherNo);
}
