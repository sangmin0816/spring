package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseNotice {
    private int noticeNo;
    private int courseNo;
    private String title;
    private String content;
    private String regdate;
    private int visited = 0;
}
