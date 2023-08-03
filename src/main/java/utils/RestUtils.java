package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

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
}
