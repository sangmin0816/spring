package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<Comment> commentList(int par);

    void commentInsert(Comment dto);

    void commentUpdate(Comment dto);

    public void commentDelete(int dno);
}
