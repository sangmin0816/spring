package kr.ed.haebeop.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
  private int dno;
  private int payNo;
  private String memId;
  private String name;
  private String tel;
  private String address;

  private String dcom;
  private String dtel;
  private int state = 0;
  private String etd;
  private String eta;
  private String dcode;
}
