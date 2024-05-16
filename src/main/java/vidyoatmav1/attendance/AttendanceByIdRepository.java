package vidyoatmav1.attendance;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface AttendanceByIdRepository extends CassandraRepository<AttendanceByPersonId, UUID> {
    List<AttendanceByPersonId> findByPersonId(UUID personId);
}
