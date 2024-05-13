package vidyoatmav1.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.StudentByInstitutionId;
import vidyoatmav1.model.tablehelpers.Address;
import vidyoatmav1.requests.AddStudentRequest;
import vidyoatmav1.responses.AfterAddStudentResponse;
import vidyoatmav1.support.GenerateAuthentication;

@Service
@RequiredArgsConstructor
public class StudentService {
        private final GenerateAuthentication generate;

        public AfterAddStudentResponse save(AddStudentRequest addrequest) {
                UUID _id = UUID.randomUUID();
                Address _address = new Address(addrequest.getBuildingno(), addrequest.getLocality(),
                                addrequest.getCity(),
                                addrequest.getDistrict(), addrequest.getState(), addrequest.getCountry());
                System.out.println(addrequest);
                var student = StudentByInstitutionId.builder()
                                .instiutionId(_id)
                                .firstName(addrequest.getFirstname())
                                .secondName(addrequest.getSecondname())
                                .studentId(_id)
                                .admissionNo(addrequest.getAdmissionno())
                                .address(_address)
                                .standards(addrequest.getStandards())
                                .roleNumber(addrequest.getRolenumber())
                                .section(addrequest.getSection());
                System.out.println(student);
                String credentials = generate.generateCredentials("DAV", addrequest.getAdmissionno(),
                                addrequest.getFirstname());
                // need to save in table
                return AfterAddStudentResponse
                                .builder()
                                .username(credentials)
                                .password(credentials)
                                .build();
        }
}
