package airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import pojos.Airline;
import restutilities.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload) throws IOException {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPostFromMap(endPoint, createAirlinePayload, new HashMap<>());
        return response;
    }

    public Response createAirlineFromPojo(Airline createAirlinePayload) throws JsonProcessingException {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPostFromPojo(endPoint, createAirlinePayload, new HashMap<>());
        return response;
    }

    public Response createAirlineFromStringPayload(String createAirlinePayload) throws JsonProcessingException {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
        return response;
    }

}
