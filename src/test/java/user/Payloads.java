package user;

import pojos.User;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    //    public static String getCreateAirlinesPayloadFromString(String id) {
//        //String name, String country, String
//        //            logo, String slogan, String headquarters, String website, String established)
//
//        String payLoad = "{\n" +
//                "    \"id\": " + id + ",\n" +
//                "    \"name\": \"Sri Lankan Airways\",\n" +
//                "    \"country\": \"Sri Lanka\",\n" +
//                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
//                "    \"slogan\": \"From Sri Lanka\",\n" +
//                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
//                "    \"website\": \"www.srilankaairways.com\",\n" +
//                "    \"established\": \"1990\"\n" +
//                "}";
//        return payLoad;
//    }
//
    public static Map<String, Object> getCreateUsersPayloadFromMap(String name, String jobName) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("job", jobName);
        return payload;
    }
//
//    public static Map<String, Object> getCreateAirlinesPayloadFromFakerData() {
//        HashMap<String, Object> payload = new HashMap<>();
//        payload.put("id", RandomDataGenerator.getRandomNumber(10));
//        payload.put("name", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.FIRSTNAME));
//        payload.put("country", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.COUNTRYNAME));
//        payload.put("logo", RandomDataGenerator.getRandomAlphabets(25));
//        payload.put("slogan", RandomDataGenerator.getRandomAlphabets(25));
//        payload.put("head_quaters", RandomDataGenerator.getRandomTestDataFor(RandomDataTypeNames.CITYNAME));
//        payload.put("website", RandomDataGenerator.getRandomWebsite(10));
//        payload.put("established", RandomDataGenerator.getRandomNumberBetweenRange(1900, DateUtils.getCurrentYear()));
//        return payload;
//    }


    public static User getCreateUserPayloadFromPojo() {
        return User.builder().build();
    }
}
