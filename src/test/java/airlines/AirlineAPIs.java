package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public void createAirline(Map<String, Object> createAirlinePayload) {

        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response = RestUtils.performPostFromMap(endPoint, createAirlinePayload, new HashMap<>());
    }
}
