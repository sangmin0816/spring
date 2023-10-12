package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private int rno;
    private String id;
    private int ano;
    private String rdate;
    private String rtime;
    private String status = "pending";
}