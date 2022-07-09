package tests;

import data.ExcelReader;
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

import java.io.File;
import java.io.IOException;




public class AccountTests {
    protected HomePage homePage;
    protected SignIn signInPage;
    public MyAccountPage myAccount;
    protected WomenPage womenPage;

    String className = AccountTests.class.getName();


    @DataProvider(name = "ExcelData")
    public Object[][] userLoginData() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataLogin();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void launchBrowser(String browserName) {
        BrowserActions.initializer(className, browserName);
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }


    @Test(groups = "loginGroup", dataProvider = "ExcelData")
    public void Login(String email, String password) {
        signInPage = homePage.clickOnSignIn();
        signInPage.enterEmailToLogin(email);
        signInPage.enterPasswordToLogin(password);
        myAccount = signInPage.clickOnLoginButton();
    }

    @Test(dependsOnGroups = "loginGroup")
    public void goToWomen() {
        womenPage = myAccount.clickOnWomen();
    }

    @Test(dependsOnMethods = "goToWomen")
    public void goToProfile() {

        womenPage.clickProfile();
    }

    @AfterClass
    public void tearDown() {
        BrowserActions.closeDriverAndRemoveFromMap(className);
    }

    @AfterMethod
    public static void takeScreeshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String className = AccountTests.class.getName();
            TakesScreenshot screenshot = (TakesScreenshot) BrowserActions.getDriver(className);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshots/" + ".png"));
        }
    }

}


