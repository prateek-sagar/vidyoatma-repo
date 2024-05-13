package vidyoatmav1.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequest {
    private String firstname;
    private String secondname;
    private int admissionno;
    private String buildingno;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
    private int standards;
    private int rolenumber;
    private Section section;
}
