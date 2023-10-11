package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RCalendar {
    private int cno;
    private int academy;
    private String rdate;
    private String rtime;
    private int capacity = 2;
}
