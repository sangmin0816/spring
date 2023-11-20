package kr.ed.haebeop.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Comment {
    private int commentNo;
    private String id;
    private String content;
    private String regdate;
    private int freeNo;
}
