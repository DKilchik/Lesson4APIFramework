package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestReqres {

    @Test
    public void testListUser(){

        String url = "https://reqres.in/api/users?page=2";

        Allure.addAttachment("URL: ", url);

        Response resp = get(url);

        Allure.addAttachment("response body", resp.body().prettyPrint());
        Allure.addAttachment("status code", String.valueOf(resp.statusCode()));

        resp.then().assertThat().statusCode(200);
    }

    @Test
    public void testSingleUser(){

        String url = "https://reqres.in/api/users/2";

        Allure.addAttachment("URL: ", url);

        Response resp = get(url);

        Allure.addAttachment("response body", resp.body().prettyPrint());
        Allure.addAttachment("status code", String.valueOf(resp.statusCode()));

        resp.then().assertThat().statusCode(200);

    }
}
