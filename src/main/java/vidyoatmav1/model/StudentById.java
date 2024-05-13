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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class StudentById {
    @PrimaryKeyColumn(value = "student_id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private int admissionNo;
    @Column
    private UUID institutionId;
    @Column
    private Address address;
    @Column
    private int standards;
    @Column
    private int roleNumber;
    @Column
    private Section section;
    @Column
    private String fatherName;
    @Column
    private String motherName;
    @Column
    private List<String> phoneNumbers;
}
