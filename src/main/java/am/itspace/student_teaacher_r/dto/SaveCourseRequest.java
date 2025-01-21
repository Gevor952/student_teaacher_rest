package am.itspace.student_teaacher_r.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCourseRequest {

    @NotEmpty(message = "title can't be empty")
    private String title;
    @NotNull(message = "description can't be null")
    private String description;
    private int teacherId;
}
