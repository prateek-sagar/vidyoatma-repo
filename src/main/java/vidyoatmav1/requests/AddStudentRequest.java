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
    private UUID institution_id;
    private int admission_no;
    private PersonBasicInfoRequest basic;
    private AddressRequest address;
    private int standards;
    private int role_number;
    private Section section;
}
