package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
    public static Faker faker = new Faker();


    public static String getRandomTestDataFor(RandomDataTypeNames randomDataTypeNames) {
        switch (randomDataTypeNames) {
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case CITYNAME:
                return faker.address().cityName();
            case COUNTRYNAME:
                return faker.address().country();
            default:
                return "";
        }
    }

    public static String getRandomNumber(int count) {
        return faker.number().digits(count);
    }

    public static String getRandomAlphabets(int limit) {
        return RandomStringUtils.randomAlphabetic(limit);
    }

    public static int getRandomNumberBetweenRange(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static String getRandomWebsite(int count) {
        return "https://" + RandomStringUtils.randomAlphabetic(count) + ".com";
    }


}
