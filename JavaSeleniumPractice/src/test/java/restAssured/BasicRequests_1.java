package restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Most of the Application have three tier architecture Presentation layer>>Application Layer>>Data Layer
 * API=Domain(BaseURI)+path Param+Query Param
 * Format for sending Request:
 * given()-->pre-requisites,header,body and params
 * when()-->actions,hitting requests defining end points
 * then()-->response validation,extracting values from response
 */
public class BasicRequests_1 {

    @Test
    public void getRequest()
    {
        RestAssured.baseURI="https://reqres.in";
        Response res = given()
                .when()
                .get("/api/users/")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println("Status code"+res.statusCode());
        System.out.println("Time of response:"+res.getTime());
    }
    static String bookingId;
    @Test
    public void postRequest()
    {
        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        Response res = given()
                .header("Content-Type", " application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Shivam\",\n" +
                        "    \"lastname\" : \"Komawar\",\n" +
                        "    \"totalprice\" : 450,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2025-01-01\",\n" +
                        "        \"checkout\" : \"2025-12-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println(res.statusCode());

        //to extract response we can use jsonPath()
        JsonPath jp = res.jsonPath();
        bookingId =jp.get("bookingid").toString();
    }
    @Test(dependsOnMethods = {"postRequest"})
    public void putRequest()
    {
        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        Response res = given()
                .header("Content-Type", " application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Pavan\",\n" +
                        "    \"lastname\" : \"Kumar\",\n" +
                        "    \"totalprice\" : 980,\n" +
                        "    \"depositpaid\" : false,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2025-01-01\",\n" +
                        "        \"checkout\" : \"2025-12-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Lunch\"\n" +
                        "}")
                .when()
                .put("booking/"+bookingId)
                .then().extract().response();
        System.out.println(res.asPrettyString());
        System.out.println(res.statusCode());
    }

}
