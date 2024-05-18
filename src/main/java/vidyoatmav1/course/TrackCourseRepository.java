package vidyoatmav1.course;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface TrackCourseRepository extends CassandraRepository<TrackCourse, UUID> {
    List<TrackCourse> findByInstitutionId(UUID institutionId);
}
