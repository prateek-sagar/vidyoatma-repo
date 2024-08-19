package vidyoatmav1.model.tablehelpers;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@UserDefinedType
public class Student extends Persons {
    private int standard;
    private Section section;
    private int roleNumber;
    private int admissionNo;
}
