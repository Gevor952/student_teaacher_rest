package am.itspace.student_teaacher_r.dto;

import am.itspace.student_teaacher_r.entity.Role;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SaveUserRequest {

    private String name;
    private String surname;
    private String email;
    private Role role;

}
