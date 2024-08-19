package vidyoatmav1.model.tablehelpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persons {
    private PersonBasicInfo basicInfo;
    private Address address;
}
