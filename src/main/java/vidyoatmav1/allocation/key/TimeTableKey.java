package vidyoatmav1.allocation.key;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PrimaryKeyClass
public class TimeTableKey {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private int standard;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Section section;
}
