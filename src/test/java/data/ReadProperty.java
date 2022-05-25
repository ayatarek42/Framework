package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    public static Properties loginData;



    public static Properties loadProperties(String path) throws IOException {

        Properties property = new Properties();
        FileInputStream stream = new FileInputStream(path);
        property.load(stream);
        return property;
    }


    static {
        try {
            loginData = loadProperties(System.getProperty("user.dir")+ "/src/main/java/properties/loginDataProperties");
        } catch (IOException e) {
            System.out.println("error occured: " + e.getMessage());
        }
    }
}
