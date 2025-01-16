package am.itspace.student_teaacher_r.service.impl;

import am.itspace.student_teaacher_r.converter.CourseConverter;
import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;
import am.itspace.student_teaacher_r.entity.Course;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.repository.CourseRepository;
import am.itspace.student_teaacher_r.repository.UserRepository;
import am.itspace.student_teaacher_r.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;


    @Override
    public CourseDTO save(SaveCourseRequest saveCourseRequest) {
        User teacher = userRepository.findById(saveCourseRequest.getTeacherId()).orElse(null);
        Course course = CourseConverter.fromSaveCourseRequesttoCourse(saveCourseRequest, teacher);
        return CourseConverter.fromCourseToCourseDTO(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> findAllCourseDTO() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(CourseConverter.fromCourseToCourseDTO(course));
        }
        return courseDTOs;
    }

    @Override
    public CourseDTO findCourseById(int id) {
        return CourseConverter.fromCourseToCourseDTO(Objects.requireNonNull(courseRepository.findById(id).orElse(null)));
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    @Override
    public CourseDTO update(int id, SaveCourseRequest saveCourseRequest) {
        User teacher = userRepository.findById(saveCourseRequest.getTeacherId()).orElse(null);
        Course course = CourseConverter.fromSaveCourseRequesttoCourse(saveCourseRequest, teacher);
        course.setId(id);
        return CourseConverter.fromCourseToCourseDTO(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> findAllCourseDTOByTeacher(int teacherId) {
        List<Course> courses =courseRepository.findByTeacherId(teacherId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(CourseConverter.fromCourseToCourseDTO(course));
        }
        return courseDTOs;
    }


}
