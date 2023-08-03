package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AirlinesTests {
    Random randomObj = new Random();
    String endPoint = "https://api.instantwebtools.net/v1/airlines";
    Map<String, Object> payLoad = Payloads.getCreateAirlinesPayloadFromMap(String.valueOf(randomObj.nextInt(10000)), "RV Airlines", "IN", "ABC",
            "ABC Slogan", "Delhi", "xyz", "2000");

//    @Test
//    public void createAirlines() {
//        Response response = RestUtils.performPost(endPoint, payLoad, new HashMap<>());
//        Assert.assertEquals(response.statusCode(), 200);
//
//
//    }

    @Test
    public void createAirlinesFromMap() {
        Response response = RestUtils.performPostFromMap(endPoint, payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);


    }
}
