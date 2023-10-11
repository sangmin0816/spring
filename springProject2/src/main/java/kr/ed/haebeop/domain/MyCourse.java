package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCourse {
    private int mno;
    private int course;
    private String id;
    private int totalTime;
    private boolean state = false;
}
