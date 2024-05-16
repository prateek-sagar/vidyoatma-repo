package vidyoatmav1.attendance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.requests.AttendanceRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/student")
    public ResponseEntity<Void> saveAttendance(@RequestBody AttendanceRequest request) {
        return attendanceService.save(request);
    }
}
