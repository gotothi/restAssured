package gotoTestesApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class BaseRequest {

    private Response response;

    @BeforeClass
    public static void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public Response requestGet(String getBaseUrl, String getPath, HashMap getParameters, HashMap getHeaders) {
        RestAssured.baseURI = getBaseUrl;

        RequestSpecification httpRequest = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .header("Content-Type", "application/json")
                .headers(getHeaders)
                .params(getParameters)
                .log().all()
                .when();

        response = httpRequest.get(getPath);

        return response;
    }

    public Response requestPost(String postBaseUrl, String postPath, HashMap postHeaders, String postBody) {
        RestAssured.baseURI = postBaseUrl;

        response = (Response) RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .header("Content-Type", "application/json")
                .headers(postHeaders)
                .body(postBody)
                .log().all()

                .when()
                .post(postPath)

                .then()
                .extract();

        return response;
    }

    public Response requestPut(String putBaseUrl, String putPath, HashMap putHeaders, String putBody) {
        RestAssured.baseURI = putBaseUrl;

        response = (Response) RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .header("Content-Type", "application/json")
                .headers(putHeaders)
                .body(putBody)
                .log().all()

                .when()
                .put(putPath)

                .then()
                .extract();

        return response;
    }
}
