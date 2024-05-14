package vidyoatmav1.repositories;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.StudentByUUID;

import java.util.List;

public interface StudentByUUIDRepository extends CassandraRepository<StudentByUUID, UUID> {
    List<StudentByUUID> findByStudentId(UUID studentId);
}
