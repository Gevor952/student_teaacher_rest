package am.itspace.student_teaacher_r.converter;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;
import am.itspace.student_teaacher_r.entity.Course;
import am.itspace.student_teaacher_r.entity.User;

public class CourseConverter {

    public static Course fromCourseDTOtoCourse(CourseDTO courseDTO) {
        return Course.builder()
                .title(courseDTO.getTitle())
                .description(courseDTO.getDescription())
                .teacher(courseDTO.getTeacher())
                .build();
    }

    public static CourseDTO fromCourseToCourseDTO(Course course) {
        return CourseDTO.builder()
                .title(course.getTitle())
                .description(course.getDescription())
                .teacher(course.getTeacher())
                .build();
    }

    public static Course fromSaveCourseRequesttoCourse(SaveCourseRequest saveCourseRequest, User teacher) {
        return Course.builder()
                .title(saveCourseRequest.getTitle())
                .description(saveCourseRequest.getDescription())
                .teacher(teacher)
                .build();
    }

}
