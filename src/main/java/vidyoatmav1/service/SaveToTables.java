package vidyoatmav1.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.authentication.InstitutionRegisterRequest;
import vidyoatmav1.model.InstitutionByUUID;
import vidyoatmav1.model.InstitutionByUUIDAndName;
import vidyoatmav1.model.StudentByInstitutionIdAndName;
import vidyoatmav1.model.StudentByUUID;
import vidyoatmav1.model.TeacherByInstitutionIdAndName;
import vidyoatmav1.model.TeachersByUUID;
import vidyoatmav1.model.key.StudentByInstitutionKey;
import vidyoatmav1.model.key.TeacherByInstitutionKey;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.model.tablehelpers.OrganizationBasicInfo;
import vidyoatmav1.model.tablehelpers.PersonBasicInfo;
import vidyoatmav1.repositories.InstitutionByNameRepository;
import vidyoatmav1.repositories.InstitutionByUUIDRepository;
import vidyoatmav1.repositories.StudentByNameRepository;
import vidyoatmav1.repositories.StudentByUUIDRepository;
import vidyoatmav1.repositories.TeacherIdRepository;
import vidyoatmav1.repositories.TeacherInstitutionIdAndNameRepository;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.requests.AddTeacherRequest;
import vidyoatmav1.requests.AddressRequest;
import vidyoatmav1.requests.PersonBasicInfoRequest;

@Service
@RequiredArgsConstructor
public class SaveToTables {
        private final InstitutionByNameRepository institutionNameRepo;
        private final InstitutionByUUIDRepository institutionIdRepo;
        private final TeacherIdRepository teacherIdRepo;
        private final TeacherInstitutionIdAndNameRepository teacherNameRepo;
        private final StudentByUUIDRepository studentIdRepo;
        private final StudentByNameRepository studentNameRepo;

        public void saveInstitution(UUID id, InstitutionRegisterRequest registerRequest) {
                OrganizationBasicInfo basicInfo = OrganizationBasicInfo.builder()
                                .name(registerRequest.getName())
                                .establishmentDate(registerRequest.getEstablishmentDate()).build();
                Address _address = _setAddress(registerRequest.getAddress());
                InstitutionByUUID institutionById = InstitutionByUUID.builder()
                                .institutionId(id)
                                .basicInfo(basicInfo)
                                .abreviate(registerRequest.getAbreviate())
                                .address(_address)
                                .lowerStandard(registerRequest.getLowerStandard())
                                .higherStandard(registerRequest.getHigherStandard()).build();
                InstitutionByUUIDAndName institutionByName = InstitutionByUUIDAndName.builder()
                                .institutionId(id)
                                .findName(registerRequest.getName())
                                .basicInfo(basicInfo)
                                .address(_address)
                                .abreviate(registerRequest.getAbreviate())
                                .lowerStandard(registerRequest.getLowerStandard())
                                .higherStandard(registerRequest.getHigherStandard()).build();
                System.out.println(institutionById);
                System.out.println(institutionByName);
                institutionIdRepo.save(institutionById);
                institutionNameRepo.save(institutionByName);
        }

        public void saveTeachers(UUID id, AddTeacherRequest addrequest) {
                PersonBasicInfo basicInfo = setPersonBasicInfo(addrequest.getBasic());
                Address _address = _setAddress(addrequest.getAddress());
                TeachersByUUID teacherById = TeachersByUUID.builder()
                                .teacherId(id)
                                .institutionId(addrequest.getInstitutionid())
                                .basicInfo(basicInfo)
                                .address(_address)
                                .standards(addrequest.getStandards())
                                .subjects(addrequest.getSubjects())
                                .build();
                TeacherByInstitutionIdAndName teacherByName = TeacherByInstitutionIdAndName.builder()
                                .key(TeacherByInstitutionKey.builder().instiutionId(addrequest.getInstitutionid())
                                                .findName(addrequest.getBasic().getFirstname()).build())
                                .teacherId(id)
                                .basicInfo(basicInfo)
                                .employeeCode(Integer.toString(addrequest.getEmployeecode()))
                                .standards(addrequest.getStandards())
                                .subjects(addrequest.getSubjects())
                                .build();
                teacherIdRepo.save(teacherById);
                teacherNameRepo.save(teacherByName);
        }

        public void saveStudents(UUID id, AddStudentRequest addrequest) {
                PersonBasicInfo basicInfo = setPersonBasicInfo(addrequest.getBasic());
                Address _address = _setAddress(addrequest.getAddress());
                StudentByUUID studentById = StudentByUUID.builder()
                                .studentId(id)
                                .basicInfo(basicInfo)
                                .admissionNo(addrequest.getAdmissionno())
                                .institutionId(addrequest.getInstitutionid())
                                .address(_address)
                                .standard(addrequest.getStandards())
                                .roleNumber(addrequest.getRolenumber())
                                .section(addrequest.getSection())
                                .build();
                StudentByInstitutionIdAndName studentByName = StudentByInstitutionIdAndName.builder()
                                .key(StudentByInstitutionKey.builder()
                                                .instiutionId(addrequest.getInstitutionid())
                                                .findName(addrequest.getBasic().getFirstname())
                                                .build())
                                .basicInfo(basicInfo)
                                .studentId(id)
                                .admissionNo(addrequest.getAdmissionno())
                                .standard(addrequest.getStandards())
                                .section(addrequest.getSection())
                                .roleNumber(addrequest.getRolenumber())
                                .build();
                studentIdRepo.save(studentById);
                studentNameRepo.save(studentByName);
        }

        private PersonBasicInfo setPersonBasicInfo(PersonBasicInfoRequest request) {
                boolean n = (request.getGender() == 'f') ? true : false;
                return PersonBasicInfo.builder()
                                .firstName(request.getFirstname())
                                .lastName(request.getSecondname())
                                .dateOfBirth(request.getDob())
                                .isFemale(n)
                                .build();
        }

        private Address _setAddress(AddressRequest request) {
                return Address.builder()
                                .building_no(request.getBuilding_no())
                                .locality(request.getLocality())
                                .city(request.getCity())
                                .district(request.getDistrict())
                                .state(request.getState())
                                .country(request.getCountry())
                                .build();

        }
}
