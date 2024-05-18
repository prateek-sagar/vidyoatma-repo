package vidyoatmav1.token;

// import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Table
public class Token {
    private String token;
    private boolean isExpired;
    private boolean isRevoked;

}
