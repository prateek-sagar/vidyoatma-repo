package vidyoatmav1.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Embedded.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("standard_by_institution_id")
public class StandardByInstitutionId {

    @PrimaryKeyColumn(value = "", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private int standard;

    @Column
    private List<UUID> studentUuids;

    @Column
    @Nullable
    private UUID mentor;

}
