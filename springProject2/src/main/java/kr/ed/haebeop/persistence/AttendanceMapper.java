package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    public List<Attendance> attendanceAllList(String dateYearMonth);
    public List<Attendance> attendanceList(Attendance attendance);
    public int attendanceListCount(Attendance attendance);
    public void attendanceUserInsert(Attendance attendance);

}