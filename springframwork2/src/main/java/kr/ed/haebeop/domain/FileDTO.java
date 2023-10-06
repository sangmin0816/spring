package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
    private int fno;
    private String fileName;
    private String saveName;
    private String fileType;
    private String saveFolder;
}
