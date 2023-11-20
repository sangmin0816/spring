package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> commentList();
    public Comment commentGet(int commentNo);
    public int commentCount();
    public void commentInsert(Comment comment);
    public void commentUpdate(String content);
    public void commentDelete(int commentNo);
    public List<Comment> commentFreeList(int freeNo);
}
