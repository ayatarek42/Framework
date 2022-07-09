package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import tests.MyAccountTests_CSV;
import utilities.BrowserActions;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void takeScreeshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String className = MyAccountTests_CSV.class.getName();
            TakesScreenshot screenshot = (TakesScreenshot) BrowserActions.getDriver(className);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshotsImages/" + ".png"));
        }
    }
}
