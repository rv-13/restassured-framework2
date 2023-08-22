package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name = RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.FIRSTNAME);
    private String job = RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.JOBNAME);


}
