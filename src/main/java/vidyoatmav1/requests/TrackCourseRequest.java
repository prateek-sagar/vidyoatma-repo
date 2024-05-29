package vidyoatmav1.requests;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.course.Routine;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackCourseRequest {

    private UUID institutionId;
    private int session;
    private int standard;
    private Section section;
    private String subjectName;
    private int chapter;
    private float haveDone;
    private Routine routine;

}
