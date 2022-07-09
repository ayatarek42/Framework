package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    public static Properties URLData;



    public static Properties loadProperties(String path) throws IOException {

        Properties property = new Properties();
        FileInputStream stream = new FileInputStream(path);
        property.load(stream);
        return property;
    }

    static {
        try {
            URLData = loadProperties(System.getProperty("user.dir")+ "/src/main/java/propertiesFile/URLData");
        } catch (IOException e) {
            System.out.println("error occured: " + e.getMessage());
        }
    }
}
