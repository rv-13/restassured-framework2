package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload) {

        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPostFromMap(endPoint, createAirlinePayload, new HashMap<>());
        return response;
    }

    public Response createAirlineFromStringPayload(String createAirlinePayload) {

        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
        return response;
    }

}
