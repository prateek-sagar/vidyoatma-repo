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
        return ResponseEntity.ok(authService.authenticate(authRequest, response));
    }

    @PostMapping("/register/institution")
    public HttpStatus register(@RequestBody InstitutionRegisterRequest registerRequest,
            HttpServletResponse response) {

        var resp = authService.saveInstitution(registerRequest, response);
        if (resp == null) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.CREATED;
    }
}
