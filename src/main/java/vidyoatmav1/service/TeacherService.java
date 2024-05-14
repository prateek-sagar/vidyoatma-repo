package vidyoatmav1.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.repositories.TeacherIdRepository;
import vidyoatmav1.repositories.TeacherInstitutionIdAndNameRepository;
import vidyoatmav1.requests.AddTeacherRequest;
import vidyoatmav1.responses.AfterAddResponse;
import vidyoatmav1.support.GenerateAuthentication;

@Service
@RequiredArgsConstructor

public class TeacherService {
    private final TeacherInstitutionIdAndNameRepository teacher_institutionid_name_Repo;
    private final TeacherIdRepository teacher_repo;
    private final GenerateAuthentication generateAuthentication;

    public AfterAddResponse saveTeacher(AddTeacherRequest addrequest) {

        // String uspername = generateAuthentication.generateCredentials(null, 0, null);
        return null;
    }
}
