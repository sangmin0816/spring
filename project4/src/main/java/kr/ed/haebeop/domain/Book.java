package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bookNo;
    private int courseNo;
    private String title;
    private String content;
    private String publish;
    private String publishDate;
    private String author;
    private int imageFile;
    private int price = 0;
}
