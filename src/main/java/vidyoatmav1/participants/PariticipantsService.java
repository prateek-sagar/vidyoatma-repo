package vidyoatmav1.participants;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.repositories.StudentByUUIDRepository;
import vidyoatmav1.repositories.TeacherIdRepository;

@Service
@RequiredArgsConstructor
public class PariticipantsService {
    private final InstitutionByUUIDRepository institutionRepository;
    private final TeacherIdRepository teacherRepository;
    private final StudentByUUIDRepository studentRepository;

    public Optional<InstitutionByUUID> institution(UUID id) {
        return institutionRepository.findByInstitutionId(id);
    }

}
