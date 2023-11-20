package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int teacherNo;
    private String id;
    private String name;
    private String tel;
    private String email;
    private int imageFile = 0;
    private String career;
}
