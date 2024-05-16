package vidyoatmav1.attendance;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
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
public class AttendanceByPersonId {
    @PrimaryKeyColumn(value = "personId", type = PrimaryKeyType.PARTITIONED)
    private UUID personId;
    @PrimaryKeyColumn(value = "date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private LocalDate date;
    @Column
    private boolean isAbsent;
}
