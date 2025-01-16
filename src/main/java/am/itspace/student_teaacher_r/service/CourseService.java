package am.itspace.student_teaacher_r.service;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;

import java.util.List;

public interface CourseService {

    CourseDTO save(SaveCourseRequest SaveCourseRequest);

    List<CourseDTO> findAllCourseDTO();

    CourseDTO findCourseById(int id);

    void delete(int id);

    CourseDTO update(int id, SaveCourseRequest saveCourseRequest);

    List<CourseDTO> findAllCourseDTOByTeacher(int teacherId);
}
