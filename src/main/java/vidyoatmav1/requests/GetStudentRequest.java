package vidyoatmav1.requests;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentRequest {
    private UUID institutionId;
    private int standard;
    private Section section;
}
