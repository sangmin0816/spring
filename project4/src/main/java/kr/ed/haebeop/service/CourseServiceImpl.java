package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.persistence.CourseMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> courseList() {
        return courseMapper.courseList();
    }

    @Override
    public Course courseGet(int courseNo) {
        return courseMapper.courseGet(courseNo);
    }

    @Override
    public int courseCount() {
        return courseMapper.courseCount();
    }

    @Override
    public void courseInsert(Course course) {
        courseMapper.courseInsert(course);
    }

    @Override
    public void courseDelete(int courseNo) {
        courseMapper.courseDelete(courseNo);
    }

    @Override
    public void courseUpdate(Course course) {
        courseMapper.courseUpdate(course);
    }

    @Override
    public List<Course> courseOnList() {
        return courseMapper.courseOnList();
    }

    @Override
    public List<Course> courseTeacherList(int teacherNo) {
        return courseMapper.courseTeacherList(teacherNo);
    }

    @Override
    public List<Course> coursePageList(Page page) {
        return courseMapper.coursePageList(page);
    }

    @Override
    public List<Course> courseTitleList(Page page) {
        return courseMapper.courseTitleList(page);
    }

    @Override
    public int courseTitleCount(Page page) {
        return courseMapper.courseTitleCount(page);
    }
}
