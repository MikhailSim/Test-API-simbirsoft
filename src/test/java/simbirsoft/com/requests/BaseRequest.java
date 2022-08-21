package simbirsoft.com.requests;

import simbirsoft.com.helpers.ParametersProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    protected String host;
    protected String token;

    protected BaseRequest() throws IOException {
        host = ParametersProvider.getProperty("url");
        token = ParametersProvider.getProperty("authToken");
    }

    protected RequestSpecification givenWithAuth() {
        return given().headers("Authorization", "OAuth " + token, "Content-Type", "application/json");
    }

    protected RequestSpecBuilder getRequestBuilder(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAccept("*/*");
    }

}