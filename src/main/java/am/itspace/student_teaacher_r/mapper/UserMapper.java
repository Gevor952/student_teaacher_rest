package am.itspace.student_teaacher_r.mapper;

import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    abstract public UserDTO toDTO(User user);

    abstract  public User toUser(SaveUserRequest saveUserRequest);

}
