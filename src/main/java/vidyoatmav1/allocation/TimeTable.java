package vidyoatmav1.allocation;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.allocation.key.TimeTableKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "time_table")
public class TimeTable {
    @PrimaryKey
    private TimeTableKey key;
    @Column(value = "period_info")
    private List<PeriodInfo> periodInfo;
}
