package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseNo;
    private int category;
    private String title;
    private String content;
    private String teacher;
    private boolean textbook = false;
    private int price = 0;
    private int capacity = 0;
    private boolean online = true;
    private String startdate;
    private String enddate;
    private String period;
    private String video;
}