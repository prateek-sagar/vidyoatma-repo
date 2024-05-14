package vidyoatmav1.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBasicInfoRequest {
    private String firstname;
    private String secondname;
    private Date dob;
    private char gender;
}
