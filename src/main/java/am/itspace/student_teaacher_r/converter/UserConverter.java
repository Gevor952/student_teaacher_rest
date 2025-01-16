package am.itspace.student_teaacher_r.converter;


import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    static public UserDTO formUserToUserDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }

    static public User fromSaveUserRequestToUser(SaveUserRequest saveUserRequest) {
        return User.builder()
                .name(saveUserRequest.getName())
                .surname(saveUserRequest.getSurname())
                .email(saveUserRequest.getEmail())
                .role(saveUserRequest.getRole())
                .build();
    }

}
