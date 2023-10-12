package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    public List<Reservation> reservationList();
    public List<Reservation> reservationAcademyDateList(Reservation reservation);
    public List<Reservation> reservationGetTimeList(Reservation reservation);
    public List<Reservation> reservationAcademyList(int ano);


    public Reservation reservationGet(int rno);
    public void reservationInsert(Reservation reservation);

    public void reservationUpdateStatus(Reservation reservation);
}
