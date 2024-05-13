package vidyoatmav1.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.AuthenticationByUsername;

public interface AuthenticationByNameRepo extends CassandraRepository<AuthenticationByUsername, String> {
    Optional<AuthenticationByUsername> findByLoginName(String loginName);
}
