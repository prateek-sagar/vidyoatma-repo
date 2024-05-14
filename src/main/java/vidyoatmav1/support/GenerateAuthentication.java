package vidyoatmav1.support;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.AuthenticationByEmailOrName;
import vidyoatmav1.repositories.AuthenticationByEmailOrNameRepository;

@Component
@RequiredArgsConstructor
public class GenerateAuthentication {

    private final AuthenticationByEmailOrNameRepository authenticationUsername;

    public String generateCredentials(String abreviate, int admissionNo, String name) {
        String addmissionNumberString = Integer.toString(admissionNo);
        String username = abreviate.toLowerCase() + addmissionNumberString.toLowerCase() + name.toLowerCase();
        int suffix = 0;
        boolean isExist = checkExist(username);
        while (isExist) {
            username = username + Integer.toString(suffix);
            isExist = checkExist(username);
            suffix++;
        }
        return username;
    }

    private boolean checkExist(String username) {
        /*
         * check for username in the username table
         */
        Optional<AuthenticationByEmailOrName> user = authenticationUsername.findByLoginEmailOrName(username);
        System.out.println(user);
        if (user.isPresent())
            return true;

        return false;
    }
}
