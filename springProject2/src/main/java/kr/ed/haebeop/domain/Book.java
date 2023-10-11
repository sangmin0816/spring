package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private String bindex;
    private String publisher;
    private String pubdate;
    private int price = 0;
    private boolean hasFile = false;
}
