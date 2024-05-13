package vidyoatmav1.authentication;

import java.util.UUID;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionRegisterRequest {
    private String username;
    private String password;
    private Role role;
    private UUID id;
    private String name;
    private String building_no;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
    private Date establishmentDate;
    private int lowerStandard;
    private int higherStandard;
}
