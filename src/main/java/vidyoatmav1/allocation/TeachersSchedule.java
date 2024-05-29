package vidyoatmav1.allocation;

import java.util.UUID;
import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
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
@Table(value = "teachers_schedule")
public class TeachersSchedule {
    @PrimaryKeyColumn(value = "instituion_id", type = PrimaryKeyType.PARTITIONED)
    @Indexed
    private UUID institutionId;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    @Indexed
    private UUID teacher;
    @Column
    private String name;
    @Column
    private List<Integer> subjects;
    @Column
    private List<Integer> standards;
}
