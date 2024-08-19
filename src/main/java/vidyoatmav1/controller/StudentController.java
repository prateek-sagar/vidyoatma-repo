package vidyoatmav1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.StudentBySection;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.requests.GetStudentRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<AfterAddResponse> saveStudent(@RequestBody AddStudentRequest addrequest) {
        System.out.println(addrequest);
        return ResponseEntity.ok(studentService.save(addrequest));
    }

    @PostMapping("/get")
    public ResponseEntity<List<StudentBySection>> getStudent(@RequestBody GetStudentRequest request) {
        return ResponseEntity.ok(studentService.getStudents(request));
    }
}
