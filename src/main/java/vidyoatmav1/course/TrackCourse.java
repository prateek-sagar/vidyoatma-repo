package vidyoatmav1.course;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.course.key.TrackCourseKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("track_course")
public class TrackCourse {
    @PrimaryKey
    private TrackCourseKey key;
    @Column(value = "num_chapters")
    private float numChapters;
    @Column(value = "num_read_chapters")
    private float numReadChapters;
    private List<Float> progress;
}
