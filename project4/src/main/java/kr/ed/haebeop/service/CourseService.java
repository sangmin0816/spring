package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.domain.Notice;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface CourseService {
    public List<Course> courseList();
    public Course courseGet(int courseNo);
    public int courseCount();
    public void courseInsert(Course course);
    public void courseUpdate(Course course);
    public void courseDelete(int courseNo);

    public List<Course> courseOnList();
    public List<Course> courseTeacherList(int teacherNo);
    public List<Course> coursePageList(Page page);
    public List<Course> courseTitleList(Page page);
    public int courseTitleCount(Page page);
}
