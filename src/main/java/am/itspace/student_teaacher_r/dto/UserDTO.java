package am.itspace.student_teaacher_r.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

    private String name;
    private String surname;
    private String email;

}
