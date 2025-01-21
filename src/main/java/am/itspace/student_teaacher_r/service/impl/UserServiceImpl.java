package am.itspace.student_teaacher_r.service.impl;

import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.exception.UserNotFoundException;
import am.itspace.student_teaacher_r.mapper.UserMapper;
import am.itspace.student_teaacher_r.repository.UserRepository;
import am.itspace.student_teaacher_r.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDTO> findAllUserDTO() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(userMapper.toDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO findUserDTOById(int id) {
        return userMapper.toDTO(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id)));
    }

    @Override
    public User update(int id, SaveUserRequest saveUserRequest) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        User user = userMapper.toUser(saveUserRequest);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    @Override
     public UserDTO save(SaveUserRequest saveUserRequest) {
        return userMapper.toDTO(userRepository.save(userMapper.toUser(saveUserRequest)));

    }


}
