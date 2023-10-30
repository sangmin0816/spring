package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseNo;
    private int teacherNo;
    private int categoryNo;
    private String title;
    private String content;
    private int videoFile;
    private boolean isOngoing = true;
    private int price = 0;
    private int capacity = 0;
}
