package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Comment;
import kr.ed.haebeop.persistence.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> commentList() {
        return commentMapper.commentList();
    }

    @Override
    public Comment commentGet(int commentNo) {
        return commentMapper.commentGet(commentNo);
    }

    @Override
    public int commentCount() {
        return commentMapper.commentCount();
    }

    @Override
    public void commentInsert(Comment comment) {
        commentMapper.commentInsert(comment);
    }

    @Override
    public void commentDelete(int commentNo) {
        commentMapper.commentDelete(commentNo);
    }

    @Override
    public void commentUpdate(String content) {
        commentMapper.commentUpdate(content);
    }

    @Override
    public List<Comment> commentFreeList(int freeNo) {
        return commentMapper.commentFreeList(freeNo);
    }
}
