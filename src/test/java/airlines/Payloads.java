package airlines;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateAirlinesPayloadFromString(String id)   {
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
}
