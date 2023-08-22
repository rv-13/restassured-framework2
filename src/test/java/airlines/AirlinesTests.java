package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Airline;

import java.io.IOException;
import java.util.Map;

import static restutilities.RestUtils.randomObj;

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

    @Test
    public void createAirlinesFromDataFaker() throws IOException {
        Map<String, Object> payLoad = Payloads.getCreateAirlinesPayloadFromFakerData();
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test
    public void createAirlinesFromPojo() throws IOException {
//        Airline payLoad = Payloads.getCreateAirlinePayloadFromPojo();
        Airline airlinePayload = new Airline();
        Response response = createAirlineFromPojo(airlinePayload);
        Assert.assertEquals(response.statusCode(), 200);

    }

//    @Test
//    public void createAirlinesAndVerifyResponse() throws IOException {
//        Airline airlinePayload = new Airline();
//        Response response = createAirlineFromPojo(airlinePayload);
//        Assert.assertEquals(response.statusCode(), 200);
//        Assert.assertEquals(response.jsonPath().getString("name"), airlinePayload.getName());
//        ObjectMapper objectMapper = new ObjectMapper();
//        Airline createAirlineResponse = objectMapper.readValue(response.getBody().asString(), Airline.class);
//        Assert.assertEquals(createAirlineResponse, airlinePayload);
//
//    }
}
