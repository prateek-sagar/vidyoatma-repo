package vidyoatmav1.finance;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface AccountsRepository extends CassandraRepository<AccountByGroupId, UUID> {
    List<AccountByGroupId> findByGroupId(UUID groupId);
}
