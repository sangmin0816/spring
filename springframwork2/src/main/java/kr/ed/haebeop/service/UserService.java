package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.User;

import java.util.List;

public interface UserService {
    public List<User> userList() throws Exception;
    public int userCount() throws Exception;
    public User userGet(String id) throws Exception;

    public User login1(String id) throws Exception;
    public boolean login2(User user) throws Exception;
    public User login3(String id) throws Exception;

    public void userInsert(User user) throws Exception;
    public void userDelete(String id) throws Exception;
    public void userUpdate(User user) throws Exception;
}
