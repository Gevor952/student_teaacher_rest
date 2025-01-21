package am.itspace.student_teaacher_r.service.impl;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;
import am.itspace.student_teaacher_r.entity.Course;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.exception.CourseNotFoundException;
import am.itspace.student_teaacher_r.exception.UserNotFoundException;
import am.itspace.student_teaacher_r.mapper.CourseMapper;
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
    private final CourseMapper courseMapper;


    @Override
    public CourseDTO save(SaveCourseRequest saveCourseRequest) {
        Course course = courseMapper.toEntity(saveCourseRequest);
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> findAllCourseDTO() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(courseMapper.toDto(course));
        }
        return courseDTOs;
    }

    @Override
    public CourseDTO findCourseById(int id) {
        if(!courseRepository.existsById(id)){
            throw new CourseNotFoundException("Course with id " + id + " not found");
        }
        return courseMapper.toDto(Objects.requireNonNull(courseRepository.findById(id).orElse(null)));
    }

    @Override
    public void delete(int id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course with id " + id + " not found");
        }
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    @Override
    public CourseDTO update(int id, SaveCourseRequest saveCourseRequest) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course with id " + id + " not found");
        }
        Course course = courseMapper.toEntity(saveCourseRequest);
        course.setId(id);
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> findAllCourseDTOByTeacher(int teacherId) {
        if (!userRepository.existsById(teacherId)) {
            throw new UserNotFoundException("Teacher with id " + teacherId + " not found");
        }
        List<Course> courses =courseRepository.findByTeacherId(teacherId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(courseMapper.toDto(course));
        }
        return courseDTOs;
    }


}
