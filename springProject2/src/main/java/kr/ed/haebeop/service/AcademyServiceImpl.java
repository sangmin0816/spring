package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.persistence.AcademyMapper;
import kr.ed.haebeop.util.PageAcademy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService{
    @Autowired
    AcademyMapper academyMapper;

    @Override
    public List<Academy> academyList(PageAcademy page) {
        return academyMapper.academyList(page);
    }

    @Override
    public List<Academy> academyAdminList(String id) {
        return academyMapper.academyAdminList(id);
    }

    @Override
    public Academy academyGet(int ano) {
        return academyMapper.academyGet(ano);
    }

    @Override
    public int academyCount(PageAcademy page) {
        return academyMapper.academyCount(page);
    }
}
