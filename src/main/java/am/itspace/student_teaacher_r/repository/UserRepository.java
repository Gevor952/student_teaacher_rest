package am.itspace.student_teaacher_r.repository;

import am.itspace.student_teaacher_r.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
