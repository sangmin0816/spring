import kr.co.teaspoon.dto.Sample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Repository
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class TestEx1 {
    private static final Logger logger = LoggerFactory.getLogger(TestEx1.class);

    @Autowired
    private DataSource ds;
    @Test
    public void testConnection(){
        try (Connection con = ds.getConnection()){
            System.out.println("MariaDB 연결 성공 : " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Inject
    private SqlSessionFactory sqlFactory;
    @Test
    public void testFactory(){
        logger.info("sqlFactory: "+sqlFactory);
        System.out.println("sqlFactory: "+sqlFactory);
    }

    @Test
    public void testSession() throws Exception{
        try{
            SqlSession session = sqlFactory.openSession();
            logger.info("MyBatis Connection success! session: "+session);
            System.out.println("MyBatis Connection success! session: "+session);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Inject
    private SqlSession sqlSession;
    @Test
    public void repositoryTest(){
        List<Sample> sampleList = sqlSession.selectList("sample.sampleList");
        for(Sample sample: sampleList){
            logger.info(sample.toString());
            System.out.println(sample.toString());
        }
    }

}