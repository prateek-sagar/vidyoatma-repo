package vidyoatmav1.repositories;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.key.StudentByInstitutionKey;
import vidyoatmav1.model.tablehelpers.StudentById;

import java.util.List;

public interface STBInstitutionIdRepo extends CassandraRepository<StudentById, StudentByInstitutionKey> {
    List<StudentById> findByInstitutionIdAndFirstName(UUID id, String firstName);
}
