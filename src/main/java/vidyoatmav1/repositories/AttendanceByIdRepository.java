package vidyoatmav1.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.AttendanceByStudentId;
import java.util.List;

public interface AttendanceByIdRepository extends CassandraRepository<AttendanceByStudentId, UUID> {
    List<AttendanceByStudentId> findByStudentId(UUID studentId);
}
