package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int cno;
    private String title;
    private String content;
    private String teacher;
    private int maxStudent;
    private int price;
}
