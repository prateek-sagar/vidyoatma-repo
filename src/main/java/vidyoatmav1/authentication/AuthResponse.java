package vidyoatmav1.authentication;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private UUID id;
    private Role role;
    private List<String> features;
}
