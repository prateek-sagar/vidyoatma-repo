package vidyoatmav1.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.StudentBySection;
import vidyoatmav1.model.key.StudentBySectionKey;
import java.util.List;

public interface StudentBySectionRepo extends CassandraRepository<StudentBySection, StudentBySectionKey> {
    List<StudentBySection> findByKey(StudentBySectionKey key);
}
