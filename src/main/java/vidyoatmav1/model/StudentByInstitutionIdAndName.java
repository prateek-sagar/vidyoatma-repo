package vidyoatmav1.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.key.StudentByInstitutionKey;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.model.tablehelpers.PersonBasicInfo;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "students_by_institution_id_and_name")
public class StudentByInstitutionIdAndName {
    @PrimaryKey
    private StudentByInstitutionKey key;
    @Column
    private PersonBasicInfo basicInfo;
    @Column
    private UUID studentId;
    @Column
    private int admissionNo;
    @Column
    private int standard;
    @Column
    private int roleNumber;
    @Column
    private Section section;
}
