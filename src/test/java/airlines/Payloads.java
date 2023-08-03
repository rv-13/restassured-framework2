package airlines;

public class Payloads {

    public static String getCreateAirlinesPayload(String id, String name, String country, String
            logo, String slogan, String headquarters, String website, String established) {
        String payLoad = "{\n" +
                "    \"id\": "+id+",\n" +
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
}
