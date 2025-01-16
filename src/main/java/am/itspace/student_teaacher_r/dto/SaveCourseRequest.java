package am.itspace.student_teaacher_r.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCourseRequest {

    private String title;
    private String description;
    private int teacherId;
}
