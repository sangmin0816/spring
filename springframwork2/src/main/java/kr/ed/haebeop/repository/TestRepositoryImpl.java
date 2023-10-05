package kr.ed.haebeop.repository;
import kr.ed.haebeop.domain.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<TestVO> testList() throws Exception {
        return sqlSession.selectList("test.testList");
    }

    @Override
    public TestVO testGet(int num) throws Exception {
        return sqlSession.selectOne("test.testGet", num);
    }

    @Override
    public void testInsert(TestVO test) throws Exception {
        sqlSession.insert("test.testInsert", test);
    }
}
