package vidyoatmav1.allocation;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface ScheduleRepository extends CassandraRepository<TeachersSchedule, UUID> {
    List<TeachersSchedule> findByInstitutionIdAndTeacher(UUID institutionId, UUID teacher);

    List<TeachersSchedule> findByInstitutionId(UUID institutionId);

    List<TeachersSchedule> findByTeacher(UUID teacher);
}
