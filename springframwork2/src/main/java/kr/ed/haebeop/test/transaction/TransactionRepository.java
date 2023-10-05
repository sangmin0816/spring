package kr.ed.haebeop.test.transaction;

import kr.ed.haebeop.domain.Emp;
import kr.ed.haebeop.domain.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionRepository {

    @Autowired
    private SqlSession sqlSession;

    public void addTest(TestVO test){
        sqlSession.insert("test.testInsert", test);
    }

    public void addEmp(Emp emp){
        sqlSession.insert("emp.empInsert", emp);
    }

    public Emp latestEmp(){
        return sqlSession.selectOne("emp.latestEmp");
    }

    @Transactional
    public void addCollection(TestVO test, Emp emp){
        addEmp(emp);
        addTest(test);
    }

    @Transactional
    public void latestInsert(){
        Emp emp = latestEmp();
        TestVO test = new TestVO();
        test.setNum(emp.getEmp_no());
        test.setTitle(emp.getFirst_name());
        addTest(test);
    }

    @Transactional
    public void latestInsert2(){
        Emp emp = sqlSession.selectOne("emp.latestEmp");
        TestVO test = new TestVO();
        test.setNum(emp.getEmp_no());
        test.setTitle(emp.getFirst_name());
        sqlSession.insert("test.testInsert", test);
    }
}
