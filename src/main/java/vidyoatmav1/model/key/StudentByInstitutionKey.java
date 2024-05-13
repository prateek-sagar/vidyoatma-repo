package vidyoatmav1.model.key;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class StudentByInstitutionKey {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID instiutionId;
    @PrimaryKeyColumn(value = "first_name", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String firstName;
    @PrimaryKeyColumn(value = "second_name", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String secondName;
}
