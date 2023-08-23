package restutilities;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.beust.ah.A;
import io.restassured.response.Response;
import reporting.ExtentReportingManager;
import reporting.Setup;

import java.util.*;

public class AssertionUtils {
    public static void assertExpectedValuesWithJsonPath(Response response, Map<String, Object> exceptedValuesMap) {
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON_PATH", "EXPECTED_VALUE", "ACTUAL_VALUE", "RESULT"));
        boolean allMatched = true;

        Set<String> jsonPaths = exceptedValuesMap.keySet();
        for (String jsonPath : jsonPaths) {
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if (actualValue.isPresent()) {
                Object value = actualValue.get();
                if (value.equals(exceptedValuesMap.get(jsonPath))) {
                    actualValuesMap.add(new AssertionKeys(jsonPath, exceptedValuesMap.get(jsonPath), value, "MATCHED"));
                } else {
                    allMatched = false;
                    actualValuesMap.add(new AssertionKeys(jsonPath, exceptedValuesMap.get(jsonPath), value, "NOT_MATCHED"));
                }
            } else {
                allMatched = false;
                actualValuesMap.add(new AssertionKeys(jsonPath, exceptedValuesMap.get(jsonPath), "VALUE_NOT_FOUND", "NOT_MATCHED"));

            }


        }
        if (allMatched)
            ExtentReportingManager.logPassDetails("All Assertions Passed!!");
        else
            ExtentReportingManager.logFailureDetails("All Assertions are not Passed");

        String[][] arrayOfAssertions = actualValuesMap.stream().map(assertions -> new String[]{assertions.getJsonpath(), (String) assertions.getExpectedValue(),
                (String) assertions.getActualValue(), assertions.getResult()}).toArray(String[][]::new);
        Setup.extentTestThreadLocal.get().info(MarkupHelper.createTable(arrayOfAssertions));
    }
}
