package restAssured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Most of the Application have three tier architecture Presentation layer>>Application Layer>>Data Layer
 * API=Domain(BaseURI)+path Param+Query Param
 * Format for sending Request:
 * given()-->pre-requisites,header,body and params
 * when()-->actions,hitting requests defining end points
 * then()-->response validation,extracting values from response
 * PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f
 */

/**
 * HTTP Requests:
 * Get
 * Post
 * Put
 * Delete
 * Head --we only get headers in response not a body
 */
public class Chapter1_HttpRequests {

    @Test
    public void getRequest() {
        RestAssured.baseURI = "https://reqres.in";
        Response res = given()
                .when()
                .get("/api/users/")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println("Status code" + res.statusCode());
        System.out.println("Time of response:" + res.getTime());
    }

    /**
     * getWorkspaces()
     * pass header(api key) to get response
     */
    @Test
    public void getRequest2() {
        RestAssured.baseURI = "https://api.getpostman.com";
        Response res = given()
                .header("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .when()
                .get("/workspaces")
                .then()
                .extract()
                .response();
        System.out.println("response is :" + res.asPrettyString());
        System.out.println("Status code is :" + res.statusCode());
    }

    String id;

    /**
     * createWorkspace
     * post request pass body in given to create workspace
     */
    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://api.getpostman.com";
        Response res = given()
                .header("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .body("{\n" +
                        "  \"workspace\": {\n" +
                        "    \"name\": \"Automation workspace\",\n" +
                        "    \"type\": \"personal\",\n" +
                        "    \"description\": \"This is my API workspace\"\n" +
                        "  }\n" +
                        "}")
                .when()
                .post("/workspaces")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println(res.statusCode());
        JsonPath jp = res.jsonPath();
        id = jp.get("workspace.id");
        System.out.println(id);
    }

    /**
     * Update workspace
     */
    @Test()
    public void putRequest() {
        RestAssured.baseURI = "https://api.getpostman.com";
        Response res = given()
                .header("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .body("{\n" +
                        "  \"workspace\": {\n" +
                        "    \"name\": \"Updated workspace\",\n" +
                        "    \"type\": \"personal\",\n" +
                        "    \"description\": \"This is my API workspace\"\n" +
                        "  }\n" +
                        "}")
                .when()
                .put("/workspaces/" + id)
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println(res.statusCode());
    }


    /**
     * delete workspace
     */
    @Test
    public void deleteRequest() {
        RestAssured.baseURI = "https://api.getpostman.com";
        given()
                .header("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .when()
                .delete("/workspaces/" +id);
    }

    /**
     * Head request return only status code not body
     */
    @Test
    public void headRequest() {
        RestAssured.baseURI = "https://reqres.in";
        Response res = given()
                .when()
                .head("/api/users/2")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println("Status code " + res.statusCode());
        System.out.println("Time of response:" + res.getTime());

        // There are multiple ways to fetch the information
        // 1.Get the values in form of list
        Headers headers = res.getHeaders();
        List<Header> list=headers.asList();
        Header firstHeader=list.get(0);
        String name=firstHeader.getName();
        String value=firstHeader.getValue();
        System.out.println(name+" : "+value);
        System.out.println("-------------------------------------------");

        // 2.Getting all headers (Object) in one go
        Headers h=res.getHeaders();
        System.out.println(h.toString());

        // 3.fetch specific value from header
        System.out.println("-------------------------------------------");
        String contentType=res.getHeader("Content-Type");
        System.out.println(contentType);

    }
}
