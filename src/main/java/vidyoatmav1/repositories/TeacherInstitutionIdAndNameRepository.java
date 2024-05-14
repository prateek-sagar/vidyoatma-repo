package vidyoatmav1.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vidyoatmav1.model.TeacherByInstitutionIdAndName;
import vidyoatmav1.model.key.TeacherByInstitutionKey;
import java.util.List;

public interface TeacherInstitutionIdAndNameRepository
        extends CassandraRepository<TeacherByInstitutionIdAndName, TeacherByInstitutionKey> {
    List<TeacherByInstitutionIdAndName> findByKey(TeacherByInstitutionKey key);
}
