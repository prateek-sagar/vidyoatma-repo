package vidyoatmav1.requests;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequest {
    private UUID institutionid;
    private int admissionno;
    private PersonBasicInfoRequest basic;
    private AddressRequest address;
    private int standards;
    private int rolenumber;
    private Section section;
}
