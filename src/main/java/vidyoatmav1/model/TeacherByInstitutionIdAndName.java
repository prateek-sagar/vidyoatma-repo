package vidyoatmav1.model;

import java.util.UUID;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.key.TeacherByInstitutionKey;
import vidyoatmav1.model.tablehelpers.PersonBasicInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "teachers_by_institution_id_and_name")
public class TeacherByInstitutionIdAndName {
    @PrimaryKey
    private TeacherByInstitutionKey key;
    @Column
    private UUID teacherId;
    @Column
    private PersonBasicInfo basicInfo;
    @Column
    private String employeeCode;
    @Column
    private List<String> subjects;
    @Column
    private List<Integer> standards;
}
