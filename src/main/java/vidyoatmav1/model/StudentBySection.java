package vidyoatmav1.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.key.StudentBySectionKey;
import vidyoatmav1.model.tablehelpers.Student;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("stundent_by_section")
public class StudentBySection {
    @PrimaryKey
    private StudentBySectionKey key;
    @Column("student_id")
    private UUID studentId;
    @Column
    private Student student;
}
