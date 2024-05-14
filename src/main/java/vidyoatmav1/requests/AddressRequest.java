package vidyoatmav1.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String building_no;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
}
