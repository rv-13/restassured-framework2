package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static restUtils.RestUtils.randomObj;

public class AirlinesTests extends AirlineAPIs {


    @Test
    public void createAirlines() throws IOException {

        Map<String, Object> payLoad = Payloads.getCreateAirlinesPayloadFromMap(String.valueOf(randomObj.nextInt(10000)), "RV Airlines", "IN", "ABC",
                "ABC Slogan", "Delhi", "xyz", "2000");
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test
    public void createAirlinesFromString() throws IOException {

        String payLoad = Payloads.getCreateAirlinesPayloadFromString(String.valueOf(randomObj.nextInt(10000)));
        Response response = createAirlineFromStringPayload(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }


}
