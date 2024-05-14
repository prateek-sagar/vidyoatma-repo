package vidyoatmav1.repositories;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.InstitutionByUUIDAndName;

public interface InstitutionByNameRepository extends CassandraRepository<InstitutionByUUIDAndName, String> {
    List<InstitutionByUUIDAndName> findByFindName(String findName);
}
