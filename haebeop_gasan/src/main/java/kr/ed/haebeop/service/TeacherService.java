package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Teacher;


import java.util.List;


public interface TeacherService {
    public List<Teacher> teacherList();
    public Teacher teacherGet(int teacherNo);
    public int teacherCount();
    public void teacherInsert(Teacher teacher);
    public void teacherUpdate(Teacher teacher);
    public void teacherDelete(int teacherNo);
}
