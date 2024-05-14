package vidyoatmav1.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.AuthenticationByEmailOrName;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.model.tablehelpers.Role;
import vidyoatmav1.repositories.AuthenticationByEmailOrNameRepository;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.requests.AddTeacherRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.support.GenerateAuthentication;

@Service
@RequiredArgsConstructor

public class TeacherService {
    private final GenerateAuthentication generateAuthentication;
    private final InstitutionByUUIDRepository institutionByIdrepo;
    private final PasswordEncoder passwordEncoder;
    private final SaveToTables saveToTables;
    private final AuthenticationByEmailOrNameRepository usernameRepo;

    public AfterAddResponse saveTeacher(AddTeacherRequest addrequest) {
        UUID _id = UUID.randomUUID();
        Optional<InstitutionByUUID> institution = institutionByIdrepo.findByInstitutionId(_id);
        String abreviate = institution.get().getAbreviate();
        String username = generateAuthentication.generateCredentials(abreviate, addrequest.getEmployeecode(),
                addrequest.getBasic().getFirstname());
        AuthenticationByEmailOrName user = AuthenticationByEmailOrName.builder()
                .loginprincipal(username)
                .loginpass(passwordEncoder.encode(username))
                .id(_id)
                .role(Role.TEACHER)
                .build();
        usernameRepo.save(user);
        saveToTables.saveTeachers(_id, addrequest);
        return AfterAddResponse
                .builder()
                .username(username)
                .password(username)
                .build();
    }
}
