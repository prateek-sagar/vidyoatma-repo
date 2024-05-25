package vidyoatmav1.requests;

import java.time.LocalTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleRequest {
    private UUID institution_id;
    private int standard;
    private Section section;
    private String teacher;
    private String subject;
    private LocalTime start;
    private long length;
    private int row;
    private int column;
}
