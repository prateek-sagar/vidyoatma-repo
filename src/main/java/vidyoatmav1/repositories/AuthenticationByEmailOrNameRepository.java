package vidyoatmav1.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.AuthenticationByEmailOrName;

public interface AuthenticationByEmailOrNameRepository
        extends CassandraRepository<AuthenticationByEmailOrName, String> {
    Optional<AuthenticationByEmailOrName> findByLoginEmailOrName(String loginEmailOrName);
}