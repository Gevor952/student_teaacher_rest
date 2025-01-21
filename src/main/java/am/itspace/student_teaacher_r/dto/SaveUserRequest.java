package am.itspace.student_teaacher_r.dto;

import am.itspace.student_teaacher_r.entity.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SaveUserRequest {

    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotEmpty(message = "name can't be empty")
    private String surname;
    @NotEmpty(message = "email can't be empty")
    private String email;
    @NotNull(message = "roel can't be empty")
    private Role role;

}
