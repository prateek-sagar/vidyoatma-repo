package vidyoatmav1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.authentication.InstitutionRegisterRequest;
import vidyoatmav1.repositories.InstitutionByNameRepository;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.repositories.StudentByNameRepository;
import vidyoatmav1.repositories.StudentByUUIDRepository;
import vidyoatmav1.repositories.TeacherIdRepository;
import vidyoatmav1.repositories.TeacherInstitutionIdAndNameRepository;

@Service
@RequiredArgsConstructor
public class SaveToTables {
    private final InstitutionByNameRepository institutionNameRepo;
    private final InstitutionByUUIDRepository institutionIdRepo;
    private final TeacherIdRepository teacherIdRepo;
    private final TeacherInstitutionIdAndNameRepository teacherNameRepo;
    private final StudentByUUIDRepository studentIdRepo;
    private final StudentByNameRepository studentNameRepo;

    public ResponseEntity<Void> saveInstitution(InstitutionRegisterRequest registerRequest) {
        
        return ResponseEntity.ok().build();
    }
}
