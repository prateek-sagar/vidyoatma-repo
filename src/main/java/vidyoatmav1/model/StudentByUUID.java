package vidyoatmav1.model;

import java.util.UUID;
import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Embedded.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.model.tablehelpers.PersonBasicInfo;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "students_by_uuid")
public class StudentByUUID {
    @PrimaryKeyColumn(value = "student_id", type = PrimaryKeyType.PARTITIONED)
    private UUID studentId;
    @Column
    private PersonBasicInfo basicInfo;
    @Column
    private int admissionNo;
    @Column
    private UUID institutionId;
    @Column
    private Address address;
    @Column
    private int standard;
    @Column
    private int roleNumber;
    @Column
    private Section section;
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
