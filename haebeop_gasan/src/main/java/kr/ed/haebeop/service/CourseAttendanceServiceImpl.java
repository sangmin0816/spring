package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseAttendance;
import kr.ed.haebeop.persistence.CourseAttendanceMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAttendanceServiceImpl implements CourseAttendanceService{
    @Autowired
    CourseAttendanceMapper courseAttendanceMapper;

    @Override
    public List<CourseAttendance> courseAttendanceList() {
        return courseAttendanceMapper.courseAttendanceList();
    }

    @Override
    public CourseAttendance courseAttendanceGet(int courseAttendanceNo) {
        return courseAttendanceMapper.courseAttendanceGet(courseAttendanceNo);
    }

    @Override
    public void courseAttendanceInsert(CourseAttendance courseAttendance) {
        courseAttendanceMapper.courseAttendanceInsert(courseAttendance);
    }

    @Override
    public void courseAttendanceDelete(int courseAttendanceNo) {
        courseAttendanceMapper.courseAttendanceDelete(courseAttendanceNo);
    }

    @Override
    public void courseAttendanceUpdate(CourseAttendance courseAttendance) {
        courseAttendanceMapper.courseAttendanceUpdate(courseAttendance);
    }

    @Override
    public List<CourseAttendance> courseAttendancePageList(Page page) {
        return courseAttendanceMapper.courseAttendancePageList(page);
    }

    @Override
    public int courseAttendanceCount(int courseNo) {
        return courseAttendanceMapper.courseAttendanceCount(courseNo);
    }

    @Override
    public List<CourseAttendance> courseAttendanceIdList(Page page) {
        return courseAttendanceMapper.courseAttendanceIdList(page);
    }

    @Override
    public int courseAttendanceIdCount(Page page) {
        return courseAttendanceMapper.courseAttendanceIdCount(page);
    }
}
