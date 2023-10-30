package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Member;


import java.util.List;


public interface MemberService {
    public List<Member> memberList();
    public Member memberGet(String id);
    public int memberCount();
    public void memberInsert(Member member);
    public void memberUpdate(Member member);
    public void memberDelete(String id);



    public int idCheck(String id);
    public Member login(String id);
    public void memberUpdatePoint(Member member);
    public void memberVerify(String id);
    public List<Member> memberMembershipList(String membership);
}
