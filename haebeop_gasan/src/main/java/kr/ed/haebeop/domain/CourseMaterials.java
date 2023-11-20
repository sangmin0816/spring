package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterials {
    private int materialNo;
    private int courseNo;
    private String title;
    private String content;
    private String id;
    private String regdate;
    private int visited = 0;
    private boolean hasFile = false;
}
