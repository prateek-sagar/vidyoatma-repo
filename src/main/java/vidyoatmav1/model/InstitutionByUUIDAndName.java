package vidyoatmav1.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.model.tablehelpers.OrganizationBasicInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "institutions_by_uuid_and_name")
public class InstitutionByUUIDAndName {
    @PrimaryKeyColumn(value = "insitution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;
    @Indexed
    @PrimaryKeyColumn(value = "find_name", type = PrimaryKeyType.PARTITIONED)
    private String findName;
    @Column
    private OrganizationBasicInfo basicInfo;
    @Column
    private Address address;
    @Column
    private String abreviate;
    @Column
    private int lowerStandard;
    @Column
    private int higherStandard;
}
