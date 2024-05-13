package vidyoatmav1.authentication;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.authconfig.JWTService;
import vidyoatmav1.model.AuthenticationByEmail;
import vidyoatmav1.model.Institution;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.repositories.UsersByEmailRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final UsersByEmailRepository usersEmailrepo;
        private final JWTService jwtService;
        private final AuthenticationManager authenticationManager;
        private final PasswordEncoder passwordEncoder;

        public AuthResponse saveInstitution(InstitutionRegisterRequest registerRequest) {
                UUID id = UUID.randomUUID();

                var emailUser = AuthenticationByEmail
                                .builder()
                                .loginemail(registerRequest.getUsername())
                                .loginpass(passwordEncoder.encode(registerRequest.getPassword()))
                                .role(registerRequest.getRole())
                                .id(id)
                                .build();
                Address _address = new Address(
                                registerRequest.getBuilding_no(),
                                registerRequest.getLocality(),
                                registerRequest.getCity(),
                                registerRequest.getDistrict(),
                                registerRequest.getState(),
                                registerRequest.getCountry());
                var institution = Institution
                                .builder()
                                .institutionId(id)
                                .institutionName(registerRequest.getName())
                                .address(_address)
                                .establishmentDate(registerRequest.getEstablishmentDate())
                                .lowerStandard(registerRequest.getLowerStandard())
                                .higherStandard(registerRequest.getHigherStandard());
                System.out.println(emailUser);
                System.out.println(institution);
                // usersEmailrepo.save(emailUser);
                // var token = jwtService.generateToken(emailUser);
                return null;
        }

        public AuthResponse authenticate(AuthRequest authRequest) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                                                authRequest.getPassword()));

                var user = usersEmailrepo.findByLoginemail(authRequest.getUsername()).orElseThrow();
                var token = jwtService.generateToken(user);
                return AuthResponse.builder().token(token).build();
        }
}