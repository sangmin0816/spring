package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Comment;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment")
    public List<Comment> commentList();

    @Select("SELECT * FROM comment WHERE commentNo=#{commentNo}")
    public Comment commentGet(int commentNo);

    @Select("SELECT COUNT(*) FROM comment")
    public int commentCount();

    @Insert("INSERT INTO comment(content, id, freeNo) VALUES(#{content}, #{id}, #{freeNo})")
    public void commentInsert(Comment comment);

    @Update("UPDATE comment SET content=#{content} WHERE commentNo=#{commentNo}")
    public void commentUpdate(String content);

    @Delete("DELETE FROM comment WHERE commentNo=#{commentNo}")
    public void commentDelete(int commentNo);



    @Select("SELECT * FROM comment where freeNo=#{freeNo}")
    public List<Comment> commentFreeList(int freeNo);
}
