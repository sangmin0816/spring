package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseQna;
import kr.ed.haebeop.persistence.CourseQnaMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseQnaServiceImpl implements CourseQnaService{
    @Autowired
    CourseQnaMapper courseQnaMapper;

    @Override
    public List<CourseQna> courseQnaList() {
        return courseQnaMapper.courseQnaList();
    }

    @Override
    public CourseQna courseQnaGet(int courseQnaNo) {
        courseQnaMapper.courseQnaVisit(courseQnaNo);
        return courseQnaMapper.courseQnaGet(courseQnaNo);
    }

    @Override
    public void courseQnaInsert(CourseQna courseQna) {
        courseQnaMapper.courseQnaInsert(courseQna);
    }

    @Override
    public void courseQnaDelete(int courseQnaNo) {
        courseQnaMapper.courseQnaDelete(courseQnaNo);
    }

    @Override
    public void courseQnaUpdate(CourseQna courseQna) {
        courseQnaMapper.courseQnaUpdate(courseQna);
    }

    @Override
    public List<CourseQna> courseQnaPageList(Page page) {
        return courseQnaMapper.courseQnaPageList(page);
    }

    @Override
    public int courseQnaCount(int courseNo) {
        return courseQnaMapper.courseQnaCount(courseNo);
    }

    @Override
    public List<CourseQna> courseQnaIdList(Page page) {
        return courseQnaMapper.courseQnaIdList(page);
    }

    @Override
    public int courseQnaIdCount(Page page) {
        return courseQnaMapper.courseQnaIdCount(page);
    }

    @Override
    public void courseQnaVisit(int materialNo) {
        courseQnaMapper.courseQnaVisit(materialNo);
    }

    @Override
    public List<CourseQna> courseQnaTitleList(Page page) {
        return courseQnaMapper.courseQnaTitleList(page);
    }

    @Override
    public List<CourseQna> courseQnaContentList(Page page) {
        return courseQnaMapper.courseQnaContentList(page);
    }

    @Override
    public int courseQnaTitleCount(Page page) {
        return courseQnaMapper.courseQnaTitleCount(page);
    }

    @Override
    public int courseQnaContentCount(Page page) {
        return courseQnaMapper.courseQnaContentCount(page);
    }

    @Override
    public void courseQnaParUpdate() {
        courseQnaMapper.courseQnaParUpdate();
    }
}
