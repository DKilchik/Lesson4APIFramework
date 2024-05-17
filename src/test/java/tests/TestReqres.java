package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static utils.Steps.GET;
import static utils.Steps.validateStatusCode;

public class TestReqres {

    @BeforeSuite
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUser(){

        Response resp = GET("/users?page=2");

        validateStatusCode(resp, 200);
    }

    @Test
    public void testSingleUser(){

        Response resp = GET("/users/2");

        validateStatusCode(resp, 200);

    }
}
