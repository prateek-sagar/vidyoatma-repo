package vidyoatmav1.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType("address")
public class Address {
    private String building_no;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
}
