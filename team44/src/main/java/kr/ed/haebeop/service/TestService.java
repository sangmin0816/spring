package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Test;

import java.util.List;

public interface TestService {
    public List<Test> testList() throws Exception;
    public Test testGet(int num) throws Exception;
    public void testInsert(Test test) throws Exception;
}
