package vidyoatmav1.authentication;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.VAUserByEmail;
import vidyoatmav1.repositories.UsersByEmailRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersByEmailRepository usersEmailrepo;
    private final JWTService jwtService;

    public AuthResponse save(RegisterRequest registerRequest) {
        var emailUser = VAUserByEmail
                .builder()
                .loginpass(registerRequest.getLoginprincipal())
                .loginpass(registerRequest.getLoginPassword())
                .role(registerRequest.getRole())
                .build();

        usersEmailrepo.save(emailUser);
        var token = jwtService.generateToken(emailUser);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        return null;
    }
}