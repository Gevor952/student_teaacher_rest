package am.itspace.student_teaacher_r.service.impl;

import am.itspace.student_teaacher_r.converter.CourseConverter;
import am.itspace.student_teaacher_r.converter.UserConverter;
import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.CourseRegister;
import am.itspace.student_teaacher_r.repository.CourseRegisterRepository;
import am.itspace.student_teaacher_r.service.CourseRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseRegisterServiceImpl implements CourseRegisterService {

    private final CourseRegisterRepository courseRegisterRepository;

    @Override
    public List<CourseDTO> getCoursesByUserId(int userId) {
        List<CourseRegister> courseRegisters = courseRegisterRepository.findByUserId(userId);
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (CourseRegister courseRegister : courseRegisters) {
            courseDTOS.add(CourseConverter.fromCourseToCourseDTO(courseRegister.getCourse()));
        }
        return courseDTOS;
    }

    @Override
    public List<UserDTO> getStudentsByCourseId(int id) {
        List<CourseRegister> courseRegisters = courseRegisterRepository.findByCourseId(id);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (CourseRegister courseRegister : courseRegisters) {
            userDTOS.add(UserConverter.formUserToUserDTO(courseRegister.getUser()));
        }
        return userDTOS;
    }
}
