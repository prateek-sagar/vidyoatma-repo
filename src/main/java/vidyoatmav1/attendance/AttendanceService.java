package vidyoatmav1.attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.requests.AttendanceRequest;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceByIdRepository attendanceRepo;

    public ResponseEntity<Void> save(AttendanceRequest request) {
        System.out.println(request);

        savePresent(request.getPresents());
        saveAbsent(request.getAbsents());
        // attendanceRepo.save(null);
        return ResponseEntity.ok().build();
    }

    private void savePresent(List<UUID> request) {
        for (int i = 0; i < request.size(); i++) {
            AttendanceByPersonId attendance = AttendanceByPersonId.builder()
                    .personId(request.get(i))
                    .date(LocalDate.now())
                    .isAbsent(false)
                    .build();
            attendanceRepo.save(attendance);

        }

    }

    private void saveAbsent(List<UUID> request) {
        for (int i = 0; i < request.size(); i++) {
            AttendanceByPersonId attendance = AttendanceByPersonId.builder()
                    .personId(request.get(i))
                    .date(LocalDate.now())
                    .isAbsent(true)
                    .build();
            attendanceRepo.save(attendance);
        }
    }

}
