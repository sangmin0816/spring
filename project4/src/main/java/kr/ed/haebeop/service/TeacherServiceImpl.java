package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Teacher;
import kr.ed.haebeop.persistence.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> teacherList() {
        return teacherMapper.teacherList();
    }

    @Override
    public Teacher teacherGet(int teacherNo) {
        return teacherMapper.teacherGet(teacherNo);
    }

    @Override
    public void teacherInsert(Teacher teacher) {
        teacherMapper.teacherInsert(teacher);
    }

    @Override
    public void teacherDelete(int teacherNo) {
        teacherMapper.teacherDelete(teacherNo);
    }

    @Override
    public int teacherCount() {
        return teacherMapper.teacherCount();
    }

    @Override
    public void teacherUpdate(Teacher teacher) {
        teacherMapper.teacherUpdate(teacher);
    }
}
