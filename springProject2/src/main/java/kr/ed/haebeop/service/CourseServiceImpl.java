package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.persistence.CourseMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper coursemapper;
    @Override
    public List<Course> courseList(Page page) {
        return coursemapper.courseList(page);
    }

    @Override
    public Course courseGet(int cno) {
        return coursemapper.courseGet(cno);
    }

    @Override
    public Course courseGetLast() {
        return coursemapper.courseGetLast();
    }

    @Override
    public int courseCount(Page page) {
        return coursemapper.courseCount(page);
    }

    @Override
    public void courseInsert(Course course) {
        coursemapper.courseInsert(course);
    }

    @Override
    public void courseUpdate(Course course) {
        coursemapper.courseUpdate(course);
    }

    @Override
    public void courseDelete(int cno) {
        coursemapper.courseDelete(cno);
    }
}
