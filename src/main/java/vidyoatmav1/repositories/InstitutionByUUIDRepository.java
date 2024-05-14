package vidyoatmav1.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.InstitutionByUUID;

public interface InstitutionByUUIDRepository extends CassandraRepository<InstitutionByUUID, UUID> {
    Optional<InstitutionByUUID> findByInstitutionId(UUID institutionId);
}
