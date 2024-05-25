package vidyoatmav1.finance;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface GroupRepository extends CassandraRepository<Group, UUID> {
    List<Group> findByInstitutionId(UUID institutionId);

    List<Group> findAllByInstitutionId(UUID institutionId);
}
