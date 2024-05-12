package vidyoatmav1.repositories;


import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.Institution;
import vidyoatmav1.model.key.InstitutionKey;

public interface InstitutionRepository extends CassandraRepository<Institution, InstitutionKey> {

}
