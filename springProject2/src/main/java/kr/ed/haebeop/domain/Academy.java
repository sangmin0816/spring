package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Academy {
    private int ano;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String city;
    private String district;
}
