package restAssured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1.Using jsonPath method we can get the response values from output to get the values we need to provide
 * absolute json path
 */
public class Chapter2_FetchingDataFromResponse {

    @Test
    public void jsonPathMethod() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        Response res = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("/booking")
                .then()
                .extract().response();
        System.out.println(res.asPrettyString());
        JsonPath jp = res.jsonPath();
        String firstName=jp.get("booking.firstname");
        System.out.println(firstName);
        String checkInDate=jp.getString("booking.bookingdates.checkin");
        System.out.println(checkInDate);
        Assert.assertEquals(firstName, "Jim");
        System.out.println(jp.getInt("bookingid"));
    }
    @Test
    public void fetchingDataForDynamicArray()
    {
        RestAssured.baseURI="https://reqres.in/";
        Response res = given()
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then().extract().response();
        System.out.println(res.asPrettyString());
        JsonPath jp=res.jsonPath();
        int pageNo = jp.getInt("page");
        System.out.println("Current page is "+pageNo);

        //here data having multiple objects
        int dataSize=jp.getInt("data.size()");
        for (int i=0;i<dataSize;i++)
        {
            String firstName=jp.getString("data["+i+"].first_name");
            if (firstName.equals("Lindsay"))
            {
                System.out.println(jp.getString("data["+i+"].email"));
            }
        }
    }
}
