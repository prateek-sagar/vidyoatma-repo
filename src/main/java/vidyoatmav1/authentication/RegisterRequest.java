package vidyoatmav1.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String loginprincipal;
    private String loginPassword;
    private Role role;
}
