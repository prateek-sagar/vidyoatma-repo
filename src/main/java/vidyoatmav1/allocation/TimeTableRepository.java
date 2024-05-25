package vidyoatmav1.allocation;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.allocation.key.TimeTableKey;
import java.util.List;

public interface TimeTableRepository extends CassandraRepository<TimeTable, TimeTableKey> {
    List<TimeTable> findByKey(TimeTableKey key);
}
