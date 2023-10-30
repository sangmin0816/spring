package kr.ed.haebeop.domain;

import lombok.Data;


@Data
public class CourseQna {
    private int qnaNo;
    private int courseNo;
    private int lev = 0;
    private int par = 0;
    private String title;
    private String content;
    private String id;
    private String regdate;
    private int visited = 0;
}
