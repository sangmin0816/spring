package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseAttendance;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface CourseAttendanceService {
    public List<CourseAttendance> courseAttendanceList();
    public CourseAttendance courseAttendanceGet(int attendanceNo);
    public int courseAttendanceCount(int courseNo);
    public void courseAttendanceInsert(CourseAttendance courseAttendance);
    public void courseAttendanceUpdate(CourseAttendance courseAttendance);
    public void courseAttendanceDelete(int attendanceNo);

    public List<CourseAttendance> courseAttendancePageList(Page page);
    public List<CourseAttendance> courseAttendanceIdList(Page page);
    public int courseAttendanceIdCount(Page page);
}
