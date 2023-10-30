package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    public List<Course> courseList(Page page);
    public Course courseGet(int cno);
    public Course courseGetLast();
    public int courseCount(Page page);

    public void courseInsert(Course course);
    public void courseUpdate(Course course);
    public void courseDelete(int cno);
}
