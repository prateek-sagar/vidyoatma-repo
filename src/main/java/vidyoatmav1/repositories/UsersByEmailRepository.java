package vidyoatmav1.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.AuthenticationByEmail;

public interface UsersByEmailRepository extends CassandraRepository<AuthenticationByEmail, String> {
    Optional<AuthenticationByEmail> findByLoginemail(String loginemail);
}