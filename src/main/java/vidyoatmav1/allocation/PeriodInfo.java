package vidyoatmav1.allocation;

import java.time.LocalTime;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@UserDefinedType(value = "period_info")
public class PeriodInfo {
    private String teacher;
    private String subject;
    private LocalTime startTime;
    private long length;
}
