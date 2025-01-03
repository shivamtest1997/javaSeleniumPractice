package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * To use assertions in restAssured we use below dependencies:
 * 1.jackson-databind
 * 2.jsonassert
 * 3.json-schema-validator
 * we can apply assertions on multiple elements like header,status code and content-type etc
 */
public class Assertions {
    @Test
    public void m1()
    {
        RestAssured.baseURI="https://api.getpostman.com";
        given()
                .header("x-api-key","PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .when()
                .get("/workspaces")
                .then().log().all()
                .assertThat()
                .header("Server", "nginx") //assertion on header
                .contentType(ContentType.JSON)   //assertion on header
                .statusCode(200)             //assertion on status code
                .body("workspaces.name",hasItem("My Workspace"))
                .body("workspaces[1]",hasKey("createdBy"))
                .body("workspaces[1]",hasEntry("createdBy","40752912"));
    }
}
