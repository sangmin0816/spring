package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseList {
    Course course;
    Teacher teacher;
    Storage teacherImg;
    Storage video;

    private int remains = 0;
    private int registered;
}
