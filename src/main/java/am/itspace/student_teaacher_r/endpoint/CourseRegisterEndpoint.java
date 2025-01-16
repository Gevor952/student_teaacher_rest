package am.itspace.student_teaacher_r.endpoint;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.service.CourseRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseRegisterEndpoint {

    private final CourseRegisterService courseRegisterService;

    @GetMapping("/users/{id}/courses")
    public ResponseEntity<List<CourseDTO>> getCoursesByUserId(@PathVariable int id) {
        return ResponseEntity.ok(courseRegisterService.getCoursesByUserId(id));
    }

    @GetMapping("/courses/{id}/students")
    public ResponseEntity<List<UserDTO>> getStudentsByCourseId(@PathVariable int id) {
        return ResponseEntity.ok(courseRegisterService.getStudentsByCourseId(id));
    }

}
