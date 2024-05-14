package vidyoatmav1.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.model.key.InstitutionKey;

public interface InstitutionByUUIDRepository extends CassandraRepository<InstitutionByUUID, InstitutionKey> {
    Optional<InstitutionByUUID> findByInstitutionId(UUID institutionId);
}
