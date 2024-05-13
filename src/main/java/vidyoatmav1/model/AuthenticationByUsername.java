package vidyoatmav1.model;

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
@Table(value = "authentication_by_name")
@Builder
public class AuthenticationByUsername {
    @PrimaryKeyColumn(value = "login_name", type = PrimaryKeyType.PARTITIONED)
    private String loginName;
    @Column
    private String loginPassword;
    @Column
    private UUID id;
}
