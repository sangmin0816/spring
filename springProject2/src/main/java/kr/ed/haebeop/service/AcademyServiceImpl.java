package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.persistence.AcademyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademyServiceImpl implements AcademyService{
    @Autowired
    AcademyMapper academyMapper;

    @Override
    public Academy academyGet(int ano) {
        return academyMapper.academyGet(ano);
    }
}
