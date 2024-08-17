package vidyoatmav1.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest,
            HttpServletResponse response) {
        System.out.println(authRequest);
        boolean isValid = authService.isValidCredentials(authRequest);
        if (!isValid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse());
        }
        var result = authService.authenticate(authRequest, response);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/register/institution")
    public ResponseEntity<AuthResponse> register(@RequestBody InstitutionRegisterRequest registerRequest,
            HttpServletResponse response) {
        System.out.println(registerRequest);
        var resp = authService.saveInstitution(registerRequest, response);
        System.out.println(resp);
        return ResponseEntity.ok(resp);
    }
}
