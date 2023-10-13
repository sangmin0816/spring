package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.domain.Attendance;
import kr.ed.haebeop.util.PageAcademy;

import java.util.List;

public interface AcademyService {
    public List<Academy> academyList(PageAcademy page);
    public List<Academy> academyAdminList(String id);
    public Academy academyGet(int ano);
    public int academyCount(PageAcademy page);
}