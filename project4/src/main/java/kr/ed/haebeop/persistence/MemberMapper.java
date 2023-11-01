package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> memberList(Page page);
    public int memberCount(Page page);
    public List<Member> memberTeacherList(Page page);
    public int memberTeacherCount(Page page);
    public Member memberGet(String id);
    public List<Member> getTeacherMain();
    public int idCheck(String id);
    public void memberInsert(Member member);
    public void updateMemberForTeacher(String id);
    public int memberPointUpdate(Member member);
    public int memberUpdate(Member member);
    public int memberVerifyUpdate(Member member);
    public int memberActiveUpdate(Member member);
    public void removeMember(String id);

}