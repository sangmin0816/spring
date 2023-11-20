package kr.ed.haebeop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
  private int payNo;
  private String memId;
  private int course;
  private int payPrice;
  private int amount = 1;
  private String method;
  private String pcom;
  private String paccount;
}
