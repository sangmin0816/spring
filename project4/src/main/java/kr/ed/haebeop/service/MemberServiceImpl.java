package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.persistence.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> memberList() {
        return memberMapper.memberList();
    }

    @Override
    public void memberInsert(Member member) {
        memberMapper.memberInsert(member);
    }


    @Override
    public void memberUpdate(Member member) {
        memberMapper.memberUpdate(member);
    }

    @Override
    public int memberCount() {
        return memberMapper.memberCount();
    }

    @Override
    public Member memberGet(String id) {
        return memberMapper.memberGet(id);
    }

    @Override
    public void memberDelete(String id) {
        memberMapper.memberDelete(id);
    }


    @Override
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public Member login(String id) {
        return memberMapper.login(id);
    }

    @Override
    public void memberUpdatePoint(Member member) {
        memberMapper.memberUpdatePoint(member);
    }

    @Override
    public void memberVerify(String id) {
        memberMapper.memberVerify(id);
    }

    @Override
    public List<Member> memberMembershipList(String membership) {
        return memberMapper.memberMembershipList(membership);
    }
}
