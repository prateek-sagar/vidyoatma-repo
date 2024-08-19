package vidyoatmav1.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.AuthenticationByEmailOrName;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.model.StudentBySection;
import vidyoatmav1.model.key.StudentBySectionKey;
import vidyoatmav1.model.tablehelpers.Role;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.repositories.StudentBySectionRepo;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.requests.GetStudentRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.support.GenerateAuthentication;

@Service
@RequiredArgsConstructor
public class StudentService {
        private final GenerateAuthentication generate;
        private final SaveToTables saveToTables;
        private final InstitutionByUUIDRepository institutionByIdrepo;
        private final PasswordEncoder passwordEncoder;
        private final StudentBySectionRepo studentSectionRepo;

        public AfterAddResponse save(AddStudentRequest addrequest) {
                UUID _id = UUID.randomUUID();
                Optional<InstitutionByUUID> institution = institutionByIdrepo
                                .findByInstitutionId(addrequest.getInstitution_id());
                String abreviate = institution.get().getAbreviate();
                String username = generate.generateCredentials(abreviate, addrequest.getAdmission_no(),
                                addrequest.getBasic().getFirst_name());
                AuthenticationByEmailOrName user = AuthenticationByEmailOrName.builder()
                                .loginprincipal(username)
                                .loginpass(passwordEncoder.encode(username))
                                .id(_id)
                                .role(Role.STUDENT)
                                .build();
                // saveToTables.saveStudents(_id, addrequest);
                System.out.println(user);
                return AfterAddResponse.builder().username(username).password(username).build();
        }

        // Get the list of student for a section under the standard
        public List<StudentBySection> getStudents(GetStudentRequest request) {
                StudentBySectionKey key = StudentBySectionKey
                                .builder()
                                .institutionId(request.getInstitutionId())
                                .standard(request.getStandard())
                                .section(request.getSection())
                                .build();
                return studentSectionRepo.findByKey(key);
        }
}
