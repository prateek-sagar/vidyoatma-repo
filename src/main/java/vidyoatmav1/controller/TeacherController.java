package vidyoatmav1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.requests.AddTeacherRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<AfterAddResponse> addTeacher(@RequestBody AddTeacherRequest request) {
        return ResponseEntity.ok(teacherService.saveTeacher(request));
    }
}
