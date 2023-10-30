package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM member")
    public List<Member> memberList();

    @Select("SELECT * FROM member WHERE id=#{id}")
    public Member memberGet(String id);

    @Select("SELECT COUNT(*) FROM member")
    public int memberCount();

    @Insert("INSERT INTO member(id, pw, name, email, tel, addr1, addr2, postcode, birth, membership) VALUES(#{id}, #{pw}, #{name},#{email},#{tel},#{addr1},#{addr2},#{postcode},#{birth}, #{membership})")
    public void memberInsert(Member member);

    @Update("UPDATE member SET pw=#{pw}, name=#{name}, email=#{email}, tel=#{tel}, addr1=#{addr1},addr2=#{addr2}, postcode=#{postcode}, birth=#{birth} WHERE id=#{id}")
    public void memberUpdate(Member member);

    @Delete("DELETE FROM member WHERE id=#{id}")
    public void memberDelete(String id);


    @Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
    public int idCheck(String id);

    @Select("SELECT * FROM member WHERE id=#{id}")
    public Member login(String id);

    @Update("UPDATE member SET point=#{point} WHERE id=#{id}")
    public void memberUpdatePoint(Member member);

    @Update("UPDATE member set isVerify=TRUE where id=#{id}")
    public void memberVerify(String id);

    @Select("SELECT * FROM member WHERE membership=#{membership}")
    public List<Member> memberMembershipList(String membership);
}
