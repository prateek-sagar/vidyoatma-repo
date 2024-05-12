package vidyoatmav1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String building_no;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
}
