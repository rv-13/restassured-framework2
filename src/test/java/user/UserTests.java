package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.User;
import restutilities.AssertionUtils;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.*;

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

    @Test
    public void createUserAndVerifyResponse() throws IOException {
        User createUserPayload = new User();
        Response response = createUserFromPojo(createUserPayload);
        ObjectMapper objectMapper = new ObjectMapper();
        User createUserResponse = objectMapper.readValue(response.getBody().asString(), User.class);
        Assert.assertEquals(createUserResponse, createUserPayload);
    }

    @Test
    public void createUserAndVerifyAssertions() throws IOException {
        User createUserPayload = new User();
        Response response = createUserFromPojo(createUserPayload);
        Map<String, Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("name", createUserPayload.getName());
        expectedValueMap.put("job", createUserPayload.getJob());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
    }

    @DataProvider(name = "userDataProvider")
    public Iterator<User> getUsersDataFromExcel() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtils.getExcelDataAsListOfMap("TestData_restassured2", "userTestsData");
        List<User> userData = new ArrayList<>();
        for (LinkedHashMap<String, String> dataMap : excelDataAsListOfMap) {
            User user = User.builder()
                    .name(dataMap.get("name"))
                    .job(dataMap.get("job")).build();
            userData.add(user);

        }
        return userData.iterator();
    }

    @Test(dataProvider = "userDataProvider")
    public void createUserFromPojoThroughDataProvider(User user) throws IOException {
        Response response = createUserFromPojo(user);
        Assert.assertEquals(response.statusCode(), 201);

    }
}
