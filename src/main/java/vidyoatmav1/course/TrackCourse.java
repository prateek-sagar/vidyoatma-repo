package vidyoatmav1.course;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Embedded.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Section;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("track_course")
public class TrackCourse {
    @PrimaryKeyColumn(value = "institution_id", type = PrimaryKeyType.PARTITIONED)
    private UUID institutionId;

    private UUID teaherId;
    private String teacherName;
    private String subjectName;
    private int ChaptersToBeStudy;
    private int ChaptersStudied;
    private int standard;
    @Nullable
    private Section section;
    // what we study today
}
