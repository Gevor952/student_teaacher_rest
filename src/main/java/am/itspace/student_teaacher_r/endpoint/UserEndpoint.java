package am.itspace.student_teaacher_r.endpoint;


import am.itspace.student_teaacher_r.dto.SaveUserRequest;
import am.itspace.student_teaacher_r.dto.UserDTO;
import am.itspace.student_teaacher_r.entity.User;
import am.itspace.student_teaacher_r.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUser() {
        return userService.findAllUserDTO();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.findUserDTOById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody SaveUserRequest saveUserRequest, @PathVariable("id") int id) {
        return  ResponseEntity.ok(userService.update(id, saveUserRequest));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (userService.findUserDTOById(id) == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        userService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> save(@RequestBody SaveUserRequest saveUserRequest) {
        Optional<UserDTO> optionalUserDTO = userService.save(saveUserRequest);
        return optionalUserDTO.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));

    }


}


