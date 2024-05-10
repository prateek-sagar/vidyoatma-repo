package vidyoatmav1.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.authconfig.JWTService;
import vidyoatmav1.model.VAUserByEmail;
import vidyoatmav1.repositories.UsersByEmailRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersByEmailRepository usersEmailrepo;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse save(RegisterRequest registerRequest) {
        var emailUser = VAUserByEmail
                .builder()
                .loginemail(registerRequest.getUsername())
                .loginpass(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
        System.out.println(emailUser);
        usersEmailrepo.save(emailUser);
        var token = jwtService.generateToken(emailUser);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        var user = usersEmailrepo.findByLoginemail(authRequest.getUsername()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthResponse.builder().token(token).build();
    }
}