package vidyoatmav1.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.AuthenticationByEmailOrName;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.model.tablehelpers.Role;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.support.GenerateAuthentication;

@Service
@RequiredArgsConstructor
public class StudentService {
        private final GenerateAuthentication generate;
        private final SaveToTables saveToTables;
        private final InstitutionByUUIDRepository institutionByIdrepo;
        private final PasswordEncoder passwordEncoder;

        public AfterAddResponse save(AddStudentRequest addrequest) {
                UUID _id = UUID.randomUUID();
                Optional<InstitutionByUUID> institution = institutionByIdrepo
                                .findByInstitutionId(addrequest.getInstitutionid());
                String abreviate = institution.get().getAbreviate();
                String username = generate.generateCredentials(abreviate, addrequest.getAdmissionno(),
                                addrequest.getBasic().getFirstname());
                AuthenticationByEmailOrName user = AuthenticationByEmailOrName.builder()
                                .loginprincipal(username)
                                .loginpass(passwordEncoder.encode(username))
                                .id(_id)
                                .role(Role.STUDENT)
                                .build();
                saveToTables.saveStudents(_id, addrequest);
                System.out.println(user);
                return null;
        }
}
