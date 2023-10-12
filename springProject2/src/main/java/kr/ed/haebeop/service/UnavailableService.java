package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Unavailable;

import java.util.List;

public interface UnavailableService {
    public List<Unavailable> unavailableAcademyMonth(Unavailable unavailable);
    public void unavailableInsert(Unavailable unavailable);
    public void unavailableDelete(Unavailable unavailable);
}
