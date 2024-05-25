package vidyoatmav1.authentication;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import vidyoatmav1.authconfig.JWTService;
import vidyoatmav1.model.AuthenticationByEmailOrName;
import vidyoatmav1.repositories.AuthenticationByEmailOrNameRepository;
import vidyoatmav1.service.SaveToTables;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final AuthenticationByEmailOrNameRepository usersnamerepo;
        private final JWTService jwtService;
        private final AuthenticationManager authenticationManager;
        private final PasswordEncoder passwordEncoder;
        // private final SaveToTables saveToTables;
        private final CookieController cookieController;

        public AuthResponse saveInstitution(InstitutionRegisterRequest registerRequest, HttpServletResponse response) {
                if (!usersnamerepo.existsByLoginprincipal(registerRequest.getUsername())) {
                        System.out.println("Creating user");
                        UUID _id = UUID.randomUUID();
                        System.out.println(registerRequest);
                        // create user
                        AuthenticationByEmailOrName user = AuthenticationByEmailOrName.builder()
                                        .loginprincipal(registerRequest.getUsername())
                                        .loginpass(passwordEncoder.encode(registerRequest.getPassword()))
                                        .id(_id)
                                        .role(registerRequest.getRole()).build();

                        // usersnamerepo.save(user);
                        // saveToTables.saveInstitution(_id, registerRequest);
                        System.out.println(user);
                        // need to save data in users table
                        var token = jwtService.generateToken(user);
                        var refreshToken = jwtService.generateRefreshToken(user);
                        cookieController.sentHttpOnlyCookie(response, "access-token", token);
                        cookieController.sentHttpOnlyCookie(response, "refresh-token", refreshToken);
                        return AuthResponse.builder().resp(token).build();
                } else {
                        System.out.println("Exists");
                        return null;
                }
        }

        public AuthResponse authenticate(AuthRequest authRequest) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                                                authRequest.getPassword()));

                var user = usersnamerepo.findByLoginprincipal(authRequest.getUsername()).orElseThrow();
                var token = jwtService.generateToken(user);
                return AuthResponse.builder().resp(token).build();
        }
}