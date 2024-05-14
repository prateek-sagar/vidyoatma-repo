package vidyoatmav1.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.AuthenticationByEmailOrName;
import java.util.Optional;

public interface AuthenticationByEmailOrNameRepository
        extends CassandraRepository<AuthenticationByEmailOrName, String> {
    Optional<AuthenticationByEmailOrName> findByLoginprincipal(String loginprincipal);
}