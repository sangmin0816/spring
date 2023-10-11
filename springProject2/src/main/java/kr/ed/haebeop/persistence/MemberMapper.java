package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> memberList();
    public Member memberGet(String id);
    public int memberCount();
    public Member idcheck(String id);
    public Member login(String id);
    public void memberInsert(Member dto);
    public void memberUpdate(Member member);
    public void memberDelete(String id);
    public void memberUpdatePoint(Member member);
    public List<Member> getMemberId();

}
