package restAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

/**
 * RequestSpecBuilder :RequestSpecBuilder is  class in Rest Assured which provides facility
 * to define commonly used specification related with request.
 *          -Pre-requisites
 *          -Headers
 *          -baseURI
 *          -Parameters
 * ResponseSpecification:It is a class in Rest assured which provides facility to define commonly
 * used specification related to response
 *         -Validations
 *         -StatusCode
 *         -ContentType
 */
public class Chapter_4_RequestAndResponseSpecBuilder {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void initTest()
    {
        // define request spec builder
        RequestSpecBuilder reqSpecBuilder=new RequestSpecBuilder();
        reqSpecBuilder.setBaseUri("https://api.getpostman.com");
        reqSpecBuilder.addHeader("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f");
        reqSpecBuilder.setContentType(ContentType.JSON);
        reqSpecBuilder.log(LogDetail.ALL);

        requestSpecification=reqSpecBuilder.build();

        //define response spec builder
        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * we can use above defined request spec builder and response spec builder for multiple test cases
     */
    @Test
    public void getAllWorkspaces()
    {

       given(requestSpecification)
                .when()
                .get("/workspaces")
                .then()
                .spec(responseSpecification).extract().response();
    }
    @Test
    public void getWorkspaceDetail()
    {
        given(requestSpecification)
                .when()
                .get("workspaces/a8a4d288-d583-436c-ad36-b76459c5ec3c")
                .then()
                .spec(responseSpecification).extract().response();
    }

}
