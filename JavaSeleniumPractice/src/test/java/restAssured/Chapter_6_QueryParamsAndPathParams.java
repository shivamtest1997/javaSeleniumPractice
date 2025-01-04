package restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.junit.runner.Request;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Chapter_6_QueryParamsAndPathParams {
    /**
     * Query Param :It is nothing but key and value that we define using ? and = respectively
     * inside a URI so that we can filter out the desired resource from the server
     */
    @Test
    public void queryParam()
    {
        RestAssured.baseURI="https://reqres.in";
        given()
                .queryParam("page", 2)
                .log().all()
                .when()
                .get("api/users")
                .then()
                .log().all().extract().response();
    }
    /**
     * we can pass multiple query param using given().queryParams(map) which will take argument as map object
     */
    @Test
    public void queryParams()
    {
        RestAssured.baseURI="https://reqres.in";
        HashMap<String,Object> param=new HashMap<>();
        param.put("page", 2);

        given()
                .queryParams(param)
                .log().all()
                .when()
                .get("api/users")
                .then()
                .log().all().extract().response();
    }
    /**
     * Path Param : there are two ways to configure path params in URI
     * one is directly passing in request uri or by using pathParam() method
     */
    @Test
    public void pathParam()
    {
        RestAssured.baseURI="https://reqres.in";
        given()
                .pathParam("pagevalue", 4)
                .log().all()
                .when()
                .get("api/users/{pagevalue}")
                .then()
                .log().all().extract().response();

        //https://reqres.in/api/users/4
    }
}
