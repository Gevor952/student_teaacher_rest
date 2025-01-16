package am.itspace.student_teaacher_r.dto;

import am.itspace.student_teaacher_r.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDTO {
    private String title;
    private String description;
    private User teacher;
}
