package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportingManager;

import java.util.Map;
import java.util.Random;

import static io.restassured.http.ContentType.JSON;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportingManager.logInfoDetails("Base Endpoint:-" + queryableRequestSpecification.getBaseUri());
        ExtentReportingManager.logInfoDetails("Http Method Type:-" + queryableRequestSpecification.getMethod());
        ExtentReportingManager.logInfoDetails("Headers are:-");
        ExtentReportingManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportingManager.logInfoDetails("Request Payload:-");
        ExtentReportingManager.logJson(queryableRequestSpecification.getBody());

    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportingManager.logInfoDetails("Http Status Code:-" + response.getStatusCode());
        ExtentReportingManager.logInfoDetails("Response Headers:-");
        ExtentReportingManager.logHeaders(response.getHeaders().asList());
        ExtentReportingManager.logInfoDetails("Response Body:-");
        ExtentReportingManager.logJson(response.getBody().prettyPrint());

    }

    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecificationReady = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecificationReady.post();
        printRequestLogInReport(requestSpecificationReady);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPostFromMap(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecificationReady = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecificationReady.post();
        printRequestLogInReport(requestSpecificationReady);
        printResponseLogInReport(response);
        return response;
    }

    public static Random randomObj = new Random();
}
