package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.persistence.MemberMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> memberList(Page page) {
        return memberMapper.memberList(page);
    }

    @Override
    public int memberCount(Page page) {
        return memberMapper.memberCount(page);
    }

    @Override
    public List<Member> memberTeacherList(Page page) {
        return null;
    }

    @Override
    public int memberTeacherCount(Page page) {
        return 0;
    }

    @Override
    public Member memberGet(String id) {
        return memberMapper.memberGet(id);
    }

    @Override
    public List<Member> getTeacherMain() {
        return null;
    }

    @Override
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public void memberInsert(Member member) {
        memberMapper.memberInsert(member);
    }

    @Override
    public void updateMemberForTeacher(String id) {

    }

    @Override
    public int memberPointUpdate(Member member) {
        return memberMapper.memberPointUpdate(member);
    }

    @Override
    public int memberUpdate(Member member) {
        return memberMapper.memberUpdate(member);
    }

    @Override
    public int memberVerifyUpdate(Member member) {
        return memberMapper.memberVerifyUpdate(member);
    }

    @Override
    public int memberActiveUpdate(Member member) {
        return memberMapper.memberActiveUpdate(member);
    }
}
