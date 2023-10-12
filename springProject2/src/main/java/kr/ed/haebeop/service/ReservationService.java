package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> reservationList();
    public List<Reservation> reservationAcademyDateList(Reservation reservation);
    public List<Reservation> reservationAcademyList(int ano);

    public Reservation reservationGet(int rno);
    public boolean reservationInsert(Reservation reservation);
    public void reservationUpdateStatus(Reservation reservation);
}
