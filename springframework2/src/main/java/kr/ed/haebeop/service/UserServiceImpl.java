package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.repository.UserRepo;
import kr.ed.haebeop.repository.UserRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Inject
    BCryptPasswordEncoder pwEncoder;

    @Autowired
    HttpSession session;

    @Override
    public List<User> userList() throws Exception {
        return userRepo.userList();
    }

    @Override
    public int userCount() throws Exception {
        return userRepo.userCount();
    }

    @Override
    public User userGet(String id) throws Exception {
        return userRepo.userGet(id);
    }

    @Override
    public User login1(String id) throws Exception {
        return userRepo.login1(id);
    }

    @Override
    public boolean login2(User user) throws Exception {
        User isUser = userRepo.login2(user.getId());
        String inputPw = user.getPw();
        String dbPw = isUser.getPw();
        if(pwEncoder.matches(inputPw, dbPw)){
            session.setAttribute("sid", user.getId());
            return true;
        }
        return false;
    }

    @Override
    public User login3(String id) throws Exception {
        return userRepo.login3(id);
    }

    @Override
    public void userInsert(User user) throws Exception {
        String encoded = pwEncoder.encode(user.getPw());
        user.setPw(encoded);
        userRepo.userInsert(user);
    }

    @Override
    public void userDelete(String id) throws Exception {
        userRepo.userDelete(id);
    }

    @Override
    public void userUpdate(User user) throws Exception {
        userRepo.userUpdate(user);
    }
}
