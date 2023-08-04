package restUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;
import java.util.Random;

import static io.restassured.http.ContentType.JSON;

public class RestUtils {


    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(JSON)
                .body(requestPayload)
                .post().then().log().all().extract().response();
    }

    public static Response performPostFromMap(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(JSON)
                .body(requestPayload)
                .post().then().log().all().extract().response();
    }

    public static Random randomObj = new Random();
}
