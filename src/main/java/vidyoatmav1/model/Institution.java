package vidyoatmav1.model;

import java.util.Date;
import java.util.UUID;

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
@Table
@Builder
public class Institution {

    @PrimaryKeyColumn(value = "insitution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;
    @PrimaryKeyColumn(value = "name", type = PrimaryKeyType.PARTITIONED)
    private String institutionName;
    @Column
    private Address address;
    @Column
    private Date establishmentDate;
    @Column
    private int lowerStandard;
    @Column
    private int higherStandard;

}
