package vidyoatmav1.model.key;

import java.util.UUID;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class TeacherByInstitutionKey {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID instiutionId;
    @PrimaryKeyColumn(value = "findName", type = PrimaryKeyType.PARTITIONED)
    private String findName;
}
