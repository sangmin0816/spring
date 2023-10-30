package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Course;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface CourseMapper {
    public List<Course> courseList(Page page);
    public Course courseGet(int cno);
    public Course courseGetLast();
    public int courseCount(Page page);

    public void courseInsert(Course course);
    public void courseUpdate(Course course);
    public void courseDelete(int cno);
}
