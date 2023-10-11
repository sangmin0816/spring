package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Member;

import kr.ed.haebeop.persistence.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    HttpSession session;

    @Autowired
    private MemberMapper memberRepo;

    private BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Member> memberList() throws Exception {
        return memberRepo.memberList();
    }

    @Override
    public Member memberGet(String id) throws Exception {
       /* Member member = memberRepo.memberGet(id);
        if(member!=null){
            String pw = (String) session.getAttribute("spw");
            member.setPw(pw);
        }*/
        return memberRepo.memberGet(id);
    }

    @Override
    public Member login(String id) throws Exception {
        return memberRepo.login(id);
    }

    @Override
    public void memberInsert(Member dto) throws Exception {
        memberRepo.memberInsert(dto);

    }

    @Override
    public void memberDelete(String id) throws Exception {
        memberRepo.memberDelete(id);
    }

    @Override
    public void memberUpdate(Member member) throws Exception {
        Member oldMember = memberRepo.memberGet(member.getId());
        if(!oldMember.getPw().equals(member.getPw())){
            System.out.println(member.getPw());
            String bpw = bcryptPasswordEncoder.encode(member.getPw());
            member.setPw(bpw);
            System.out.println(member.getPw());
        }
        memberRepo.memberUpdate(member);
    }

    @Override
    public void memberUpdatePoint(Member member) throws Exception {
        memberRepo.memberUpdatePoint(member);
    }

    @Override
    public List<Member> getMemberId() throws Exception {
        return memberRepo.getMemberId();
    }
}
