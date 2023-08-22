package user;

import Base.Base;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import pojos.User;
import restutilities.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserAPIs extends Base {
    public Response createUserFromPojo(User createUserPayload) throws JsonProcessingException {
        String endPoint = (String) Base.dataFromJsonFile.get(properties.getProperty("BaseUriForTest"));
        Response response = RestUtils.performPostFromPojo(endPoint, createUserPayload, new HashMap<>());
        return response;
    }

    public Response createUser(Map<String, Object> createUserPayload) throws IOException {
        String endPoint = (String) Base.dataFromJsonFile.get(properties.getProperty("BaseUriForTest"));
        Response response = RestUtils.performPostFromMap(endPoint, createUserPayload, new HashMap<>());
        return response;
    }


    public Response createUserFromStringPayload(String createUserPayload) throws JsonProcessingException {
        String endPoint = (String) Base.dataFromJsonFile.get(properties.getProperty("BaseUriForTest"));
        Response response = RestUtils.performPost(endPoint, createUserPayload, new HashMap<>());
        return response;
    }
}
