package restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * to upload file we need to use multipart() method
 */
public class Chapter_7_FileUpload {
    @Test
    public void m1()
    {
        RestAssured.baseURI="https://v2.convertapi.com";

        File file=new File("D:\\images1.jpg");
        Response res = given()
                .multiPart("filename", file)
                .log().all()
                .when()
                .post("/upload ")
                .then().extract().response();

        res.prettyPrint();
    }
    @Test
    public void downloadFile() throws IOException {
        RestAssured.baseURI="https://v2.convertapi.com";

        byte[] byteArray = given()
                .log().all()
                .when()
                .get("/https://v2.convertapi.com/d/6a7oovq4fbl3980jfnsprgo0s5dxl79z ")
                .then().extract().response().asByteArray();

        FileOutputStream fos=new FileOutputStream("D:\\downloaded.jpg");
       fos.write(byteArray);
       fos.close();
    }
}
