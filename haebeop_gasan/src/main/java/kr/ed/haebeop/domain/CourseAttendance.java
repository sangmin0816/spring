package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseAttendance {
    private int attendanceNo;
    private int courseNo;
    private String id;
    private String attdate;
    private String status;
}