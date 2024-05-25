package vidyoatmav1.finance;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class AccountByGroupId {
    @PrimaryKeyColumn(value = "group_id", type = PrimaryKeyType.PARTITIONED)
    private UUID groupId;
    @Column(value = "account_id")
    private UUID accountId;
    @Column(value = "account_name")
    private String accountName;
    @Column
    private Occurrence occurence;
}
