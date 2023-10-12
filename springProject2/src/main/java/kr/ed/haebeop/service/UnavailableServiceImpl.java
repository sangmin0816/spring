package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Unavailable;
import kr.ed.haebeop.persistence.UnavailableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnavailableServiceImpl implements UnavailableService{
    @Autowired
    UnavailableMapper unavailableMapper;

    @Override
    public List<Unavailable> unavailableAcademyMonth(Unavailable unavailable) {
        return unavailableMapper.unavailableAcademyMonth(unavailable);
    }

    @Override
    public void unavailableInsert(Unavailable unavailable) {
        unavailableMapper.unavailableInsert(unavailable);
    }

    @Override
    public void unavailableDelete(Unavailable unavailable) {
        unavailableMapper.unavailableDelete(unavailable);
    }
}
