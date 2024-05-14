package vidyoatmav1.repositories;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.TeachersByUUID;

public interface TeacherIdRepository extends CassandraRepository<TeachersByUUID, UUID> {
    Optional<TeachersByUUID> findByTeacherId(UUID teacherId);
}
