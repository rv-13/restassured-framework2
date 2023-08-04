package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static restUtils.RestUtils.randomObj;

public class AirlinesTests {

    String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");

    @Test
    public void createAirlinesFromMap() throws IOException {
        Map<String, String> data = JsonUtils.getJsonDataAsMap("" + env + "/airlinesApiData.json");
        String endPoint = data.get("createAirLineEndpoint");
        Map<String, Object> payLoad = Payloads.getCreateAirlinesPayloadFromMap(String.valueOf(randomObj.nextInt(10000)), "RV Airlines", "IN", "ABC",
                "ABC Slogan", "Delhi", "xyz", "2000");
        Response response = RestUtils.performPostFromMap(endPoint, payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }


}
