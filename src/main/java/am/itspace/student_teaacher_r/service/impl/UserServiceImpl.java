package am.itspace.student_teaacher_r.service.impl;

import am.itspace.student_teaacher_r.converter.UserConverter;
import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.repository.UserRepository;
import am.itspace.student_teaacher_r.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<UserDTO> findAllUserDTO() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(UserConverter.formUserToUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO findUserDTOById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserConverter::formUserToUserDTO).orElse(null);
    }

    @Override
    public User update(int id, SaveUserRequest saveUserRequest) {
        User user = UserConverter.fromSaveUserRequestToUser(saveUserRequest);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    @Override
    public User save(SaveUserRequest saveUserRequest) {
        return userRepository.save(UserConverter.fromSaveUserRequestToUser(saveUserRequest));
    }
}
