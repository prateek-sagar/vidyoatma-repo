package vidyoatmav1.model;

import java.util.UUID;
import java.util.List;

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
public class TeachersByUUID {
    @PrimaryKeyColumn(value = "teacher_id", type = PrimaryKeyType.PARTITIONED)
    private UUID teacherId;
    @Column
    private PersonBasicInfo basicInfo;
    @Column
    private List<String> subjects;
    @Column
    private List<Integer> standards;
}
