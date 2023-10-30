package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private int fileNo;
    private String originName;
    private String saveName;
    private String savePath;
    private String boardName;
    private int boardNo;
    private String regdate;
}
