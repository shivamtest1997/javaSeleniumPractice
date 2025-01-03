package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import restAssured.pojo.BookingDates;
import restAssured.pojo.BookingPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * There are different ways to parse a body
 * 1.Directly by passing body as String
 * 2.Using HashMap
 * 3.Using Json Object (for this we use json-simple dependency)
 * 4.using POJO classes
 */
public class Chapter_3_WaysToParseBody {

    @Test
    public void passingByString() {
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
    }

    @Test
    public void usingHashMap() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-10-06");
        bookingDates.put("checkout", "2024-11-05");

        HashMap<String, Object> booking = new HashMap<>();
        booking.put("firstname", "Shivam");
        booking.put("lastname", "Komawar");
        booking.put("totalprice", 111);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Lunch");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .extract().response();

        response.prettyPrint();

        JsonPath jp = response.jsonPath();

        int bookingId = jp.getInt("bookingid");

        Response res = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/booking/" + bookingId)
                .then()
                .extract().response();

        res.prettyPrint();

        assertThat(jp.getString("booking.firstname"), equalTo("Shivam"));
        assertThat(jp.getString("booking.lastname"), equalTo("Komawar"));
        assertThat(jp.getBoolean("booking.depositpaid"), equalTo(true));
        assertThat(jp.getInt("booking.totalprice"), equalTo(111));
    }

    /**
     * using Json Object
     */
    @Test
    public void postRequestWithJsonObject() {
        //1. By using Json object
        JSONObject workspaceJson = new JSONObject();
        JSONObject details = new JSONObject();
        details.put("name", "Neetha Workspace");
        details.put("description", "This is neetha's workspace");
        details.put("type", "personal");

        workspaceJson.put("workspace", details);

        RestAssured.baseURI = "https://api.getpostman.com/";
        Response res = given()
                .header("x-api-key", "PMAK-6776b438a7002e0001526064-4ce9460b5b05d41368910bf42afa72bd8f")
                .body(workspaceJson.toString())
                .contentType("application/json")
                .when()
                .post("workspaces")
                .then()
                .extract().response();
        System.out.println(res.asPrettyString());
    }
    @Test
    public void serializationAndDeserialization()
    {

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckIn("2024-05-06");
        bookingDates.setCheckout("2024-06-06");

        BookingPOJO bookingPOJO=new BookingPOJO();
        bookingPOJO.setFirstname("Shivam");
        bookingPOJO.setLastname("Komawar");
        bookingPOJO.setTotalprice(444);
        bookingPOJO.setBookingdates(bookingDates);
        bookingPOJO.setDepositpaid(true);
        bookingPOJO.setAdditionalneeds("Lunch");

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        Response res = given()
                .header("Content-Type", "application/json")
                .body(bookingPOJO)
                .when()
                .post("/booking")
                .then()
                .extract().response();

        res.prettyPrint();


    }
}

