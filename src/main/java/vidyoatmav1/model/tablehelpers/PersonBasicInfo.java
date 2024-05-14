package vidyoatmav1.model.tablehelpers;

import java.util.Date;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@UserDefinedType
public class PersonBasicInfo {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean isFemale;
}
