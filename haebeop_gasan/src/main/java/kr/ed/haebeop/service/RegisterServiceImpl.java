package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Register;
import kr.ed.haebeop.persistence.CourseMapper;
import kr.ed.haebeop.persistence.RegisterMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Register> registerList() {
        return registerMapper.registerList();
    }

    @Override
    public Register registerGet(int registerNo) {
        return registerMapper.registerGet(registerNo);
    }

    @Transactional
    @Override
    public boolean registerInsert(Register register) {
        if(registerMapper.isRegistered(register)<=0){
            int now = registerMapper.registerStudentCount(register.getCourseNo());
            int capacity = courseMapper.courseGet(register.getCourseNo()).getCapacity();

            if((capacity-now)>0){
                registerMapper.registerInsert(register);
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerDelete(int registerNo) {
        registerMapper.registerDelete(registerNo);
    }

    @Override
    public void registerUpdate(Register register) {
        registerMapper.registerUpdate(register);
    }


    @Override
    public int registerCount() {
        return registerMapper.registerCount();
    }

    @Override
    public List<Register> registerCourseList(String id) {
        return registerMapper.registerCourseList(id);
    }

    @Override
    public List<Register> registerStudentList(int courseNo) {
        return registerMapper.registerStudentList(courseNo);
    }

    @Override
    public int registerStudentCount(int courseNo) {
        return registerMapper.registerStudentCount(courseNo);
    }

    @Override
    public int isRegistered(Register register) {
        return registerMapper.isRegistered(register);
    }
}
