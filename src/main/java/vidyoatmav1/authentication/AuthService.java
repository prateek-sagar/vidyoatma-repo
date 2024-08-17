package vidyoatmav1.authentication;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        private final SaveToTables saveToTables;
        private final CookieController cookieController;
        private final Features features;

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

                        // need to save data in users table
                        usersnamerepo.save(user);
                        saveToTables.saveInstitution(_id, registerRequest);
                        System.out.println(user);
                        List<String> _features = features.getFeatures(registerRequest.getRole());
                        var token = jwtService.generateToken(user);
                        var refreshToken = jwtService.generateRefreshToken(user);
                        cookieController.sentHttpOnlyCookie(response, "access-token", token, 24 * 60 * 60);
                        cookieController.sentHttpOnlyCookie(response, "refresh-token", refreshToken, 24 * 60 * 60 * 7);
                        return AuthResponse
                                        .builder()
                                        .id(_id)
                                        .role(registerRequest.getRole())
                                        .features(_features)
                                        .build();
                } else {
                        return null;
                }
        }

        public AuthResponse authenticate(AuthRequest authRequest, HttpServletResponse response) {
                var user = usersnamerepo.findByLoginprincipal(authRequest.getUsername()).orElseThrow();

                // System.out.println("hello, I am executing the problem is down");
                // authenticationManager.authenticate(
                // new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                // authRequest.getPassword()));

                List<String> _features = features.getFeatures(user.getRole());
                var token = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);
                cookieController.sentHttpOnlyCookie(response, "access-token", token, 24 * 60
                                * 60);
                cookieController.sentHttpOnlyCookie(response, "refresh-token", refreshToken,
                                24 * 60 * 60 * 7);
                return AuthResponse
                                .builder()
                                .id(user.getId())
                                .role(user.getRole())
                                .features(_features)
                                .build();
        }

        public boolean isValidCredentials(AuthRequest authRequest) {
                try {
                        authenticationManager.authenticate(
                                        new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                                                        authRequest.getPassword()));
                } catch (Exception e) {
                        return false;
                }
                return true;
        }
}