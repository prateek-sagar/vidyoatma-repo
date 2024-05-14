package vidyoatmav1.model;

import java.util.Date;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class AttendanceByStudentId {
    @PrimaryKeyColumn(value = "studentId", type = PrimaryKeyType.PARTITIONED)
    private UUID studentId;
    @PrimaryKeyColumn(value = "date", type = PrimaryKeyType.CLUSTERED)
    private Date date;
    @Column
    private boolean isAbsent;
}
