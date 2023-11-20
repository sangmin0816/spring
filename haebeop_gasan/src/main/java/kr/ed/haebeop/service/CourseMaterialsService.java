package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.CourseMaterials;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface CourseMaterialsService {
    public List<CourseMaterials> courseMaterialsList();
    public CourseMaterials courseMaterialsGet(int materialNo);public int courseMaterialsCount(int courseNo);
    public void courseMaterialsInsert(CourseMaterials courseMaterials);
    public void courseMaterialsUpdate(CourseMaterials courseMaterials);
    public void courseMaterialsDelete(int materialNo);



    public CourseMaterials courseMaterialsGetLast();
    public void courseMaterialsVisit(int materialNo);
    public List<CourseMaterials> courseMaterialsPageList(Page page);
    public List<CourseMaterials> courseMaterialsTitleList(Page page);
    public List<CourseMaterials> courseMaterialsContentList(Page page);
    public List<CourseMaterials> courseMaterialsIdList(Page page);
    public int courseMaterialsTitleCount(Page page);
    public int courseMaterialsContentCount(Page page);
    public int courseMaterialsIdCount(Page page);
}
