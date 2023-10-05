package kr.ed.haebeop.service;
import kr.ed.haebeop.domain.TestVO;
import java.util.List;

public interface TestService {
    public List<TestVO> testList() throws Exception;
    public TestVO testGet(int num) throws Exception;
    public void testInsert(TestVO test) throws Exception;
}
