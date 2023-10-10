package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<TestVO> testList() throws Exception {
        return testRepository.testList();
    }

    @Override
    public TestVO testGet(int num) throws Exception {
        return testRepository.testGet(num);
    }

    @Override
    public void testInsert(TestVO test) throws Exception {
        testRepository.testInsert(test);
    }
}
