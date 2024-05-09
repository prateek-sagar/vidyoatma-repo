package vidyoatmav1.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.VAUserByEmail;

public interface UsersByEmailRepository extends CassandraRepository<VAUserByEmail, String> {
    Optional<VAUserByEmail> findByLoginemail(String loginemail);
}