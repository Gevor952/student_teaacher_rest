package am.itspace.student_teaacher_r.repository;

import am.itspace.student_teaacher_r.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTeacherId(int teacherId);

}
