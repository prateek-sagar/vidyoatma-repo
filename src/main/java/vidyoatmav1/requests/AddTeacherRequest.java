package vidyoatmav1.requests;

import java.util.List;
import java.util.UUID;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTeacherRequest {
    private UUID institutionid;
    private String firstname;
    private String secondname;
    private Date dob;
    private char gender;
    private int employeecode;
    private String buildingno;
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
    private List<String> subjects;
    private List<Integer> standards;
}
