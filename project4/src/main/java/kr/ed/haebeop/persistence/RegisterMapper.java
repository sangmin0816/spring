package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Register;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegisterMapper {
    @Select("SELECT * FROM register")
    public List<Register> registerList();

    @Select("SELECT * FROM register WHERE registerNo=#{registerNo}")
    public Register registerGet(int registerNo);

    @Select("SELECT COUNT(*) FROM register")
    public int registerCount();

    @Insert("INSERT INTO register(courseNo, id) VALUES(#{courseNo}, #{id})")
    public void registerInsert(Register register);

    @Update("UPDATE register SET courseNo=#{courseNo}, id=#{id} WHERE registerNo=#{registerNo}")
    public void registerUpdate(Register register);

    @Delete("DELETE FROM register WHERE registerNo=#{registerNo}")
    public void registerDelete(int registerNo);


    @Select("SELECT * FROM register WHERE id=#{id}")
    public List<Register> registerCourseList(String id); // 회원의 수강 리스트

    @Select("SELECT * FROM register WHERE courseNo=#{courseNo}")
    public List<Register> registerStudentList(int courseNo); // 수강생 목록

    @Select("SELECT COUNT(*) FROM register WHERE courseNo=#{courseNo}")
    public int registerStudentCount(int courseNo); // 현재 수강생 수

    @Select("SELECT COUNT(*) FROM register WHERE courseNo=#{courseNo} and id=#{id}")
    public int isRegistered(Register register);
}
