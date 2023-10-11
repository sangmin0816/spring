package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> commentList(int par) throws Exception;

    void commentInsert(Comment dto) throws Exception;

    void commentUpdate(Comment dto) throws Exception;

    public void commentDelete(int dno) throws Exception;

}
