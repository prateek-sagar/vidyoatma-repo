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
public class Group {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;
    @Column(value = "group_id")
    private UUID groupId;
    @Column(value = "group_name")
    private String groupName;
    @Column(value = "type")
    private Type type;
}
