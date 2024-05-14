package vidyoatmav1.requests;

import java.util.List;
import java.util.UUID;

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
    private PersonBasicInfoRequest basic;
    private int employeecode;
    private AddressRequest address;
    private List<String> subjects;
    private List<Integer> standards;
}
