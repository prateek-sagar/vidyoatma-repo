package vidyoatmav1.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.StudentByInstitutionIdAndName;
import vidyoatmav1.model.key.StudentByInstitutionKey;
import java.util.List;


public interface StudentByNameRepository
        extends CassandraRepository<StudentByInstitutionIdAndName, StudentByInstitutionKey> {
            List<StudentByInstitutionIdAndName> findByKey(StudentByInstitutionKey key);
}
