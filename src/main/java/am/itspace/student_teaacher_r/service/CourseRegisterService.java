package am.itspace.student_teaacher_r.service;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.UserDTO;

import java.util.List;

public interface CourseRegisterService {
    List<CourseDTO> getCoursesByUserId(int userId);

    List<UserDTO> getStudentsByCourseId(int id);
}
