package vidyoatmav1.finance;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Transactions {
    @PrimaryKeyColumn(value = "account_id", type = PrimaryKeyType.PARTITIONED)
    private UUID accountId;
    @PrimaryKeyColumn(value = "due_date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private float amount;
    private Status status;
}
