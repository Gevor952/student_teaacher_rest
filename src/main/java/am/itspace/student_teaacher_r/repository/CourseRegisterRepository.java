package am.itspace.student_teaacher_r.repository;

import am.itspace.student_teaacher_r.entity.Course;
import am.itspace.student_teaacher_r.entity.CourseRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegisterRepository extends JpaRepository<CourseRegister,Integer> {

    List<CourseRegister> findByUserId(int userId);

    List<CourseRegister> findByCourseId(int courseId);

}
