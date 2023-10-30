package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseMaterials;
import kr.ed.haebeop.persistence.CourseMaterialsMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialsServiceImpl implements CourseMaterialsService{
    @Autowired
    CourseMaterialsMapper courseMaterialsMapper;

    @Override
    public List<CourseMaterials> courseMaterialsList() {
        return courseMaterialsMapper.courseMaterialsList();
    }

    @Override
    public CourseMaterials courseMaterialsGet(int courseMaterialsNo) {
        courseMaterialsMapper.courseMaterialsVisit(courseMaterialsNo);
        return courseMaterialsMapper.courseMaterialsGet(courseMaterialsNo);
    }

    @Override
    public void courseMaterialsInsert(CourseMaterials courseMaterials) {
        courseMaterialsMapper.courseMaterialsInsert(courseMaterials);
    }

    @Override
    public void courseMaterialsDelete(int courseMaterialsNo) {
        courseMaterialsMapper.courseMaterialsDelete(courseMaterialsNo);
    }

    @Override
    public void courseMaterialsUpdate(CourseMaterials courseMaterials) {
        courseMaterialsMapper.courseMaterialsUpdate(courseMaterials);
    }


    @Override
    public CourseMaterials courseMaterialsGetLast() {
        return courseMaterialsMapper.courseMaterialsGetLast();
    }

    @Override
    public List<CourseMaterials> courseMaterialsPageList(Page page) {
        return courseMaterialsMapper.courseMaterialsPageList(page);
    }

    @Override
    public int courseMaterialsCount(int courseNo) {
        return courseMaterialsMapper.courseMaterialsCount(courseNo);
    }

    @Override
    public List<CourseMaterials> courseMaterialsIdList(Page page) {
        return courseMaterialsMapper.courseMaterialsIdList(page);
    }

    @Override
    public int courseMaterialsIdCount(Page page) {
        return courseMaterialsMapper.courseMaterialsIdCount(page);
    }

    @Override
    public void courseMaterialsVisit(int materialNo) {
        courseMaterialsMapper.courseMaterialsVisit(materialNo);
    }

    @Override
    public List<CourseMaterials> courseMaterialsTitleList(Page page) {
        return courseMaterialsMapper.courseMaterialsTitleList(page);
    }

    @Override
    public List<CourseMaterials> courseMaterialsContentList(Page page) {
        return courseMaterialsMapper.courseMaterialsContentList(page);
    }

    @Override
    public int courseMaterialsTitleCount(Page page) {
        return courseMaterialsMapper.courseMaterialsTitleCount(page);
    }

    @Override
    public int courseMaterialsContentCount(Page page) {
        return courseMaterialsMapper.courseMaterialsContentCount(page);
    }
}
