package vidyoatmav1.model;

import java.util.UUID;
import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Embedded.Nullable;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.model.tablehelpers.PersonBasicInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "teachers_by_uuid")
public class TeachersByUUID {
    @PrimaryKeyColumn(value = "teacher_id", type = PrimaryKeyType.PARTITIONED)
    private UUID teacherId;
    @Column
    private UUID institutionId;
    @Column
    private PersonBasicInfo basicInfo;
    @Column
    private Address address;
    @Column
    private List<String> subjects;
    @Column
    private List<Integer> standards;
    @Column
    @Nullable
    private String fatherName;
    @Column
    @Nullable
    private String motherName;
    @Column
    @Nullable
    private List<String> phoneNumbers;
}
