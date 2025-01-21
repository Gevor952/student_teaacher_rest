package am.itspace.student_teaacher_r.mapper;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;
import am.itspace.student_teaacher_r.entity.Course;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.exception.UserNotFoundException;
import am.itspace.student_teaacher_r.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {

    @Autowired
    private UserRepository userRepository;

    public abstract CourseDTO toDto(Course course);

    @Mapping(target = "teacher", expression = "java(findUserById(request.getTeacherId()))")
    public abstract Course toEntity(SaveCourseRequest request);

    protected User findUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }
}
