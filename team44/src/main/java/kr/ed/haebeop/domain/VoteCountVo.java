package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteCountVo {

    private int lno;
    private int vno;
    private String title;
    private int cnt;
    private String colorNum;

}