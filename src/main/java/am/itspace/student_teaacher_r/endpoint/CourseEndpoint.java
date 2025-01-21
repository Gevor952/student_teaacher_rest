package am.itspace.student_teaacher_r.endpoint;

import am.itspace.student_teaacher_r.dto.CourseDTO;
import am.itspace.student_teaacher_r.dto.SaveCourseRequest;
import am.itspace.student_teaacher_r.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseEndpoint {

    private final CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> save(@RequestBody @Validated SaveCourseRequest saveCourseRequest) {
        return ResponseEntity.ok(courseService.save(saveCourseRequest));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAll() {
        return ResponseEntity.ok(courseService.findAllCourseDTO());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        courseService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable int id, @RequestBody @Validated SaveCourseRequest saveCourseRequest) {
        return ResponseEntity.ok(courseService.update(id, saveCourseRequest));
    }

    @GetMapping("/courses?teacherId")
    public ResponseEntity<List<CourseDTO>> getCoursesByTeacherId(@RequestParam int teacherId) {
        return ResponseEntity.ok(courseService.findAllCourseDTOByTeacher(teacherId));
    }


}
