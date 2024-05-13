package vidyoatmav1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.responses.AfterAddStudentResponse;
import vidyoatmav1.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentRelatedController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<AfterAddStudentResponse> saveStudent(@RequestBody AddStudentRequest addrequest) {
        return ResponseEntity.ok(studentService.save(addrequest));
    }
}
