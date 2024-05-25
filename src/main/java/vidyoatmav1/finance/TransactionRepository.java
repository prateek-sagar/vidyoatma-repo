package vidyoatmav1.finance;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends CassandraRepository<Transactions, UUID> {

    List<Transactions> findAllByAccountIdAndDueDate(UUID accountId);

    List<Transactions> findByAccountIdAndDueDate(UUID account_id, LocalDate due_date);

}
