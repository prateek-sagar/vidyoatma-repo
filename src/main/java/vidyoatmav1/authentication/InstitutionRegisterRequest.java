package vidyoatmav1.authentication;

import java.util.UUID;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Role;
import vidyoatmav1.requests.AddressRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionRegisterRequest {
    private String username;
    private String password;
    private Role role;
    private UUID id;
    private String name;
    private String abreviate;
    private AddressRequest address;
    private Date establishmentDate;
    private int lowerStandard;
    private int higherStandard;
}
