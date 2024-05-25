package vidyoatmav1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.requests.ScheduleRequest;
import vidyoatmav1.service.AllocationService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AllocationController {
    private final AllocationService allocationService;

    @PostMapping("/timetable")
    public HttpStatus setTimeTable(@RequestBody ScheduleRequest request) {
        boolean status = allocationService.updateSchedule(request);
        if (!status) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.CREATED;
    }

}
