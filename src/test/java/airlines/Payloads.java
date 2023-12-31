package airlines;

import pojos.Airline;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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
        payload.put("id", RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("country", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.COUNTRYNAME));
        payload.put("logo", RandomDataGenerator.getRandomAlphabets(25));
        payload.put("slogan", RandomDataGenerator.getRandomAlphabets(25));
        payload.put("head_quaters", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.CITYNAME));
        payload.put("website", RandomDataGenerator.getRandomWebsite(10));
        payload.put("established", RandomDataGenerator.getRandomNumberBetweenRange(1900, DateUtils.getCurrentYear()));
        return payload;
    }

    public static Airline getCreateAirlinePayloadFromPojo() {
        return Airline
                .builder().build();
    }

}
