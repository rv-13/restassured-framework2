package user;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.User;

import java.io.IOException;
import java.util.Map;

public class UserTests extends UserAPIs {

    @Test
    public void createUsersFromMap() throws IOException {
        Map<String, Object> payLoad = Payloads.getCreateUsersPayloadFromMap("RV", "Engineer");
        Response response = createUser(payLoad);
        Assert.assertEquals(response.statusCode(), 201);

    }

    @Test
    public void createUserFromPojo() throws IOException {
        User createUserPayload = new User();
        Response response = createUserFromPojo(createUserPayload);
        Assert.assertEquals(response.statusCode(), 201);

    }
}
