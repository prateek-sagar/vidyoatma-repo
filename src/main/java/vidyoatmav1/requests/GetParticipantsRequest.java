package vidyoatmav1.requests;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetParticipantsRequest {
    private UUID participantsId;
}
