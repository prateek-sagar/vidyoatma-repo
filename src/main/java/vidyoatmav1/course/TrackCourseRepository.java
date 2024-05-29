package vidyoatmav1.course;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.course.key.TrackCourseKey;

import java.util.List;

public interface TrackCourseRepository extends CassandraRepository<TrackCourse, TrackCourseKey> {
    List<TrackCourse> findByKey(TrackCourseKey key);
}
