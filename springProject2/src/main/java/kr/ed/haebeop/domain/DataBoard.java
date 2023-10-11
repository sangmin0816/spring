package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBoard {
    private int bno;
    private String title;
    private String content;
    private String author;
    private String regdate;
    private int visited = 0;
    private boolean hasFile = false;
}
