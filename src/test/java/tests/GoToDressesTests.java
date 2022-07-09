package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import screenshot.Screenshots;
import utilities.BrowserActions;
import utilities.UIActions;

import java.io.IOException;

public class GoToDressesTests {
    String className = GoToDressesTests.class.getName();
    HomePage homePage;

    @BeforeClass
    @Parameters({"browser"})
    public void launchBrowser(String browserName) {
        BrowserActions.initializer(className, browserName);
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }


    @Test
    public void goToDressesPage() throws IOException, ParseException {
        homePage.clickOnDresses();
        UIActions action = new UIActions(className);
        action.waitForTime(10);
        Assert.assertEquals(action.getPageTitle(),"Dresses - My Store");
    }


    @AfterClass
    public void tearDown() {
        BrowserActions.closeDriverAndRemoveFromMap(className);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
        Screenshots.takeScreeshot(result);
    }


}




