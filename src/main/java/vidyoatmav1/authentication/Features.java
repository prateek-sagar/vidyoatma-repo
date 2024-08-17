package vidyoatmav1.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidyoatmav1.model.tablehelpers.Role;

@Service
@RequiredArgsConstructor
public class Features {

    private List<String> institution = Stream
            .of("student_portfolio", "track_course", "notifications", "attendance", "finance", "allocation", "tsunami")
            .collect(Collectors.toList());

    private List<String> teachers = Stream
            .of("student_portfolio", "track_course", "notifications", "attendance", "finance", "allocation", "tsunami")
            .collect(Collectors.toList());

    private List<String> student = Stream
            .of("portfolio", "notifications", "attendance", "finance", "allocation")
            .collect(Collectors.toList());

    public List<String> getFeatures(Role role) {
        List<String> features = new ArrayList<String>();

        switch (role) {
            case INSTITUTION:
                features.addAll(institution);
                break;
            case TEACHER:
                features.addAll(teachers);
                break;
            case STUDENT:
                features.addAll(student);
                break;
            default:
                break;
        }
        return features;
    }
}
