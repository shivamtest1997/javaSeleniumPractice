package selenium_practice_set;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
    /**
     * property file is used to keep reusable data like browser environment etc
     * key=value
     * file should not have duplicate keys
     * */
    @Test
    public void  readData() throws IOException {
        //create object of Properties class
        Properties prop=new Properties(); //java

        //loading property file
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\test-data\\config.properties");
        prop.load(file);

        // prop.getProperty("key"); // return value of key from property file
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("appUrl"));
        System.out.println(prop.getProperty("password"));


    }
}
