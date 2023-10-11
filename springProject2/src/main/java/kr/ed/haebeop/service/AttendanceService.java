package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Attendance;

import java.util.List;

public interface AttendanceService {
    public List<Attendance> attendanceAllList(String dateYearMonth) throws Exception;
    public List<Attendance> attendanceList(Attendance attendance) throws Exception;
    public int attendanceListCount(Attendance attendance) throws Exception;
    public void attendanceUserInsert(Attendance attendance) throws Exception;
}