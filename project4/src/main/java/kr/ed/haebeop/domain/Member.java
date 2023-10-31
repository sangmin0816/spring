package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String tel;
    private String addr1;
    private String addr2;
    private String postcode;
    private String regdate;
    private String birth;
    private int point = 0;
    private int imageFile;
    private String membership = "student";
    private boolean isVerify = false;
}