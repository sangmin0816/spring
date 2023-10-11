package kr.ed.haebeop.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int categoryNo;
    private String main;
    private String sub;
}
