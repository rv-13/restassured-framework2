package airlines;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateAirlinesPayloadFromString(String id) {
        //String name, String country, String
        //            logo, String slogan, String headquarters, String website, String established)

        String payLoad = "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"Sri Lankan Airways\",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        return payLoad;
    }

    public static Map<String, Object> getCreateAirlinesPayloadFromMap(String id, String name, String country, String
            logo, String slogan, String headquarters, String website, String established) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", headquarters);
        payload.put("website", website);
        payload.put("established", established);
        return payload;
    }

    public static Map<String, Object> getCreateAirlinesPayloadFromFakerData() {
        HashMap<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("id", faker.number().digits(10));
        payload.put("name", faker.name().firstName());
        payload.put("country", faker.address().country());
        payload.put("logo", RandomStringUtils.randomAlphabetic(25));
        payload.put("slogan", RandomStringUtils.randomAlphabetic(25));
        payload.put("head_quaters", faker.address().cityName());
        payload.put("website", "https://" + RandomStringUtils.randomAlphabetic(10) + ".com");
        payload.put("established", faker.number().numberBetween(1900, 2022));
        return payload;
    }
}
