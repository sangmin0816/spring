package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Academy;
import kr.ed.haebeop.domain.Reservation;
import kr.ed.haebeop.persistence.AcademyMapper;
import kr.ed.haebeop.persistence.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    AcademyMapper academyMapper;

    @Override
    public List<Reservation> reservationList() {
        return reservationMapper.reservationList();
    }

    @Override
    public List<Reservation> reservationAcademyDateList(Reservation reservation) {
        return reservationMapper.reservationAcademyDateList(reservation);
    }

    @Override
    public Reservation reservationGet(int rno) {
        return reservationMapper.reservationGet(rno);
    }

    @Override
    @Transactional
    public boolean reservationInsert(Reservation reservation) {
        List<Reservation> reserved = reservationMapper.reservationGetTimeList(reservation);
        Academy academy = academyMapper.academyGet(reservation.getAno());
        int maxcapa = academy.getCapacity();

        boolean success = true;

        if(!reserved.isEmpty() && reserved.size()>=maxcapa){success=false;}
        else{
            reservationMapper.reservationInsert(reservation);
        }
        return success;
    }

    @Override
    public List<Reservation> reservationAcademyList(int ano) {
        List<Reservation> reservations = reservationMapper.reservationAcademyList(ano);
        return reservations;
    }

    @Override
    public void reservationUpdateStatus(Reservation reservation) {
        reservationMapper.reservationUpdateStatus(reservation);
    }
}
