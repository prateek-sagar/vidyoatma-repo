package vidyoatmav1.participants;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.requests.GetParticipantsRequest;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/get")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ParticipantsController {
    private final PariticipantsService service;

    @PostMapping("/institution")
    public ResponseEntity<InstitutionByUUID> getInstitution(@RequestBody GetParticipantsRequest request) {
        System.out.println("Request " + request);
        Optional<InstitutionByUUID> institution = service.institution(request.getParticipantsId());
        return ResponseEntity.ok(institution.get());
    }

    @GetMapping("/institution")
    public String get() {
        return "hello";
    }

    @PostMapping("/teacher")
    public String getTeacher(@RequestBody GetParticipantsRequest request) {
        return "teacher";
    }

    @PostMapping("/student")
    public String getStudent(@RequestBody GetParticipantsRequest request) {

        return "student";
    }

}
