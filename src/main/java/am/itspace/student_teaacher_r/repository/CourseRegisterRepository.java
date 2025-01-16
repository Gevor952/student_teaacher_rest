package am.itspace.student_teaacher_r.repository;

import am.itspace.student_teaacher_r.entity.CourseRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegisterRepository extends JpaRepository<CourseRegister,Integer> {
}
