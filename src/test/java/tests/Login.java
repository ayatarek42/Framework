package tests;

import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignIn;
import pages.WomenPage;
import utilities.BrowserActions;
import data.ReadProperty;
import java.io.File;
import java.io.IOException;


public class Login {
    protected HomePage homePage;
    protected SignIn signInPage;
    public MyAccountPage myAccount;
    protected WomenPage womenPage;

    String className = Login.class.getName();

    CSVReader reader;

    @BeforeClass
    public void launchBrowser() {
        BrowserActions.initializer(className, "Chrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }


    @Test(groups = "loginGroup")
    public void Login() {
        String email = ReadProperty.loginData.getProperty("email");
        String password = ReadProperty.loginData.getProperty("password");

        signInPage = homePage.clickOnSignIn();
        signInPage.enterEmailToLogin(email);
        signInPage.enterPasswordToLogin(password);
        myAccount = signInPage.clickOnLoginButton();

    }

    @Test(dependsOnMethods = "Login")
    public void logout(){
        myAccount.clickOnSignOut();
    }

    @AfterClass
    public void tearDown() {
        BrowserActions.closeDriverAndRemoveFromMap(className);
    }

    @AfterMethod
    public static void takeScreeshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String className = Login.class.getName();
            TakesScreenshot screenshot = (TakesScreenshot) BrowserActions.getDriver(className);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshots/" + ".png"));
        }
    }

}


