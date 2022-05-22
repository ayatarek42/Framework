package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;

public class BrowserActions {
    public  static HashMap<String,WebDriver> drivers = new HashMap<String, WebDriver>();
    public  static WebDriver driver;

    public static void initializer(String className,String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
            drivers.put(className, new ChromeDriver());

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
            drivers.put(className, new FirefoxDriver());

        }
        else {
            System.out.println("Driver is not available");
        }

    }

    public static void closeDriverAndRemoveFromMap(String className){
        drivers.get(className).close();
        drivers.remove(className);
    }
}
