package kr.ed.haebeop.repository;

import kr.ed.haebeop.domain.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepo{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<User> userList() throws Exception {
        return sqlSession.selectList("user.userList");
    }

    @Override
    public int userCount() throws Exception {
        return sqlSession.selectOne("user.userCount");
    }

    @Override
    public User userGet(String id) throws Exception {
        return sqlSession.selectOne("user.userGet", id);
    }

    @Override
    public User login1(String id) throws Exception {
        return sqlSession.selectOne("user.login1", id);
    }

    @Override
    public User login2(String id) throws Exception {
        return sqlSession.selectOne("user.login2", id);
    }

    @Override
    public User login3(String id) throws Exception {
        return sqlSession.selectOne("user.login3", id);
    }

    @Override
    public void userInsert(User user) throws Exception {
        sqlSession.insert("user.userInsert", user);
    }

    @Override
    public void userDelete(String id) throws Exception {
        sqlSession.delete("user.userDelete", id);
    }

    @Override
    public void userUpdate(User user) throws Exception {
        sqlSession.update("user.userUpdate", user);
    }
}
