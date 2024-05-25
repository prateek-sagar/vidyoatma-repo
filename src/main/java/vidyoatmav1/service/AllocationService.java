package vidyoatmav1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.allocation.PeriodInfo;
import vidyoatmav1.allocation.ScheduleRepository;
import vidyoatmav1.allocation.TeachersSchedule;
import vidyoatmav1.allocation.TimeTable;
import vidyoatmav1.allocation.TimeTableRepository;
import vidyoatmav1.allocation.key.TimeTableKey;
import vidyoatmav1.model.TeacherByInstitutionIdAndName;
import vidyoatmav1.model.key.TeacherByInstitutionKey;
import vidyoatmav1.repositories.TeacherInstitutionIdAndNameRepository;
import vidyoatmav1.requests.AddTeacherRequest;
import vidyoatmav1.requests.ScheduleRequest;

@Service
@RequiredArgsConstructor
public class AllocationService {

    private final ScheduleRepository scheduleRepository;
    private final TeacherInstitutionIdAndNameRepository teacherNameRepo;
    private final TimeTableRepository timeTableRepository;

    public void initialTeacherSchedule(UUID id, AddTeacherRequest request) {

        List<Integer> schedule_arr = new ArrayList<Integer>(48);

        for (int i = 0; i < schedule_arr.size(); i++) {
            schedule_arr.add(i, -1);
        }

        var _schedule = TeachersSchedule
                .builder()
                .institutionId(request.getInstitutionid())
                .teacher(id)
                .name(request.getBasic().getFirstname())
                .schedule(schedule_arr)
                .build();
        scheduleRepository.save(_schedule);
    }

    public boolean updateSchedule(ScheduleRequest request) {
        // get teacher information
        TeacherByInstitutionIdAndName teacher = teacherNameRepo
                .findByKey(TeacherByInstitutionKey.builder()
                        .instiutionId(request.getInstitution_id())
                        .findName(request.getTeacher())
                        .build())
                .get(0);
        // search for existing period info if any
        TimeTable currentTables = timeTableRepository.findByKey(TimeTableKey
                .builder()
                .institutionId(request.getInstitution_id())
                .standard(request.getStandard())
                .section(request.getSection())
                .build()).get(0);
        List<PeriodInfo> currentPeriodInfo = new ArrayList<PeriodInfo>(48);
        if (currentTables != null) {
            currentPeriodInfo = currentTables.getPeriodInfo();
        }
        var periodInfo = PeriodInfo.builder()
                .teacher(request.getTeacher())
                .subject(request.getSubject())
                .startTime(request.getStart())
                .length(request.getLength())
                .build();
        int index = request.getRow() * 8 + request.getColumn();
        currentPeriodInfo.add(index, periodInfo);
        var timeTable = TimeTable.builder()
                .key(TimeTableKey
                        .builder()
                        .institutionId(request.getInstitution_id())
                        .standard(request.getStandard())
                        .section(request.getSection())
                        .build())
                .periodInfo(currentPeriodInfo).build();
        timeTableRepository.save(timeTable);
        boolean resp = updateTeacherSchedule(teacher, request, index);
        if (resp == true) {
            return true;
        }
        return false;
    }

    private boolean updateTeacherSchedule(TeacherByInstitutionIdAndName teacher, ScheduleRequest request, int index) {
        if (teacher == null)
            return false;

        String requestSubject = request.getSubject().toLowerCase();
        int subjectIndex = teacher.getSubjects().indexOf(requestSubject);
        List<TeachersSchedule> teachersSchedules = scheduleRepository.findByTeacher(teacher.getTeacherId());
        List<Integer> schedule = teachersSchedules.get(0).getSchedule();

        schedule.add(index, subjectIndex);
        var teachers_schedule = TeachersSchedule
                .builder()
                .institutionId(request.getInstitution_id())
                .teacher(teacher.getTeacherId())
                .name(request.getTeacher())
                .schedule(schedule)
                .build();

        scheduleRepository.save(teachers_schedule);
        return true;
    }

}
