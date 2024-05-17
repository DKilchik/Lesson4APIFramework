package utils;


import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class Steps {

    @Step("GET")
    public static Response GET(String endpoint){
        Response response = get(endpoint);

        Allure.addAttachment("URL:", RestAssured.baseURI + endpoint);
        Allure.addAttachment("Response body:", response.body().prettyPrint());

        return response;
    }

    @Step("Validate Status Code")
    public static void validateStatusCode(Response response,int expectedStatusCode){
        response.then().assertThat().statusCode(expectedStatusCode);
    }
}
