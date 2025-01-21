package am.itspace.student_teaacher_r.service.impl;


import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.CourseRegister;
import am.itspace.student_teaacher_r.mapper.CourseMapper;
import am.itspace.student_teaacher_r.mapper.UserMapper;
import am.itspace.student_teaacher_r.repository.CourseRegisterRepository;
import am.itspace.student_teaacher_r.service.CourseRegisterService;
import am.itspace.student_teaacher_r.service.CourseService;
import am.itspace.student_teaacher_r.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseRegisterServiceImpl implements CourseRegisterService {

    private final CourseRegisterRepository courseRegisterRepository;
    private final UserService userService;
    private final CourseService courseService;
    private final UserMapper userMapper;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDTO> getCoursesByUserId(int userId) {
        userService.findUserDTOById(userId);
        List<CourseRegister> courseRegisters = courseRegisterRepository.findByUserId(userId);
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (CourseRegister courseRegister : courseRegisters) {
            courseDTOS.add(courseMapper.toDto(courseRegister.getCourse()));
        }
        return courseDTOS;
    }

    @Override
    public List<UserDTO> getStudentsByCourseId(int id) {
        courseService.findCourseById(id);
        List<CourseRegister> courseRegisters = courseRegisterRepository.findByCourseId(id);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (CourseRegister courseRegister : courseRegisters) {
            userDTOS.add(userMapper.toDTO(courseRegister.getUser()));
        }
        return userDTOS;
    }
}
