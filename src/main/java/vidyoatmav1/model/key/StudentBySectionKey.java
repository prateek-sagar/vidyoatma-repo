package vidyoatmav1.model.key;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyClass
public class StudentBySectionKey {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;
    @PrimaryKeyColumn(value = "standard", type = PrimaryKeyType.PARTITIONED)
    private int standard;
    @PrimaryKeyColumn(value = "section", type = PrimaryKeyType.CLUSTERED)
    private Section section;
}
