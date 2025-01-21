package am.itspace.student_teaacher_r.service;

import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAllUserDTO();

    UserDTO findUserDTOById(int id);

    User update(int id, SaveUserRequest saveUserRequest);

    void delete(int id);

    UserDTO save(SaveUserRequest saveUserRequest);
}
