package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataFile {
    private int fno;
    private String fileName;
    private String saveName;
    private String fileType;
    private String saveFolder;
    private int bno;
    private String relations = "dataBoard";
}
