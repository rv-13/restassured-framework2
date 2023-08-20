package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Airline {
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));
    private String name = RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.COUNTRYNAME);
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    private String slogan = RandomDataGenerator.getRandomAlphabets(25);
    private String head_quaters = RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebsite(10);
    private String established = String.valueOf(RandomDataGenerator.getRandomNumberBetweenRange(1900, DateUtils.getCurrentYear()));


}
