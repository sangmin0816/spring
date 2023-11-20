package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Register;


import java.util.List;


public interface RegisterService {
    public List<Register> registerList();
    public Register registerGet(int registerNo);
    public int registerCount();
    public boolean registerInsert(Register register);
    public void registerUpdate(Register register);
    public void registerDelete(int registerNo);


    public List<Register> registerCourseList(String id); // 회원의 수강 리스트
    public List<Register> registerStudentList(int courseNo); // 수강생 목록
    public int registerStudentCount(int courseNo); // 현재 수강생 수

    public int isRegistered(Register register);
}
