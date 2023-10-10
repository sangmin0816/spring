package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Test;

import kr.ed.haebeop.persistence.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testRepository;

    @Override
    public List<Test> testList() throws Exception {
        return testRepository.getTestList2();
    }

    @Override
    public Test testGet(int num) throws Exception {
        return testRepository.getTest2(num);
    }

    @Override
    public void testInsert(Test test) throws Exception {
        testRepository.insert2(test);
    }
}
