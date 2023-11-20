package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseQna;
import kr.ed.haebeop.util.Page;


import java.util.List;


public interface CourseQnaService {
    public List<CourseQna> courseQnaList();
    public CourseQna courseQnaGet(int qnaNo);
    public int courseQnaCount(int courseNo);
    public void courseQnaInsert(CourseQna courseQna);
    public void courseQnaUpdate(CourseQna courseQna);
    public void courseQnaDelete(int qnaNo);


    public void courseQnaParUpdate();
    public void courseQnaVisit(int qnaNo);
    public List<CourseQna> courseQnaPageList(Page page);
    public List<CourseQna> courseQnaTitleList(Page page);
    public List<CourseQna> courseQnaContentList(Page page);
    public List<CourseQna> courseQnaIdList(Page page);
    public int courseQnaTitleCount(Page page);
    public int courseQnaContentCount(Page page);
    public int courseQnaIdCount(Page page);
}
