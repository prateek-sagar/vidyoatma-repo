package vidyoatmav1.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class StudentByInstitutionId {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID instiutionId;
    @Indexed
    @PrimaryKeyColumn(value = "first_name", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String firstName;
    @PrimaryKeyColumn(value = "second_name", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String secondName;
    @Column
    private UUID studentId;
    @Column
    private int admissionNo;
    @Column
    private Address address;
    @Column
    private int standards;
    @Column
    private int roleNumber;
    @Column
    private Section section;
}
