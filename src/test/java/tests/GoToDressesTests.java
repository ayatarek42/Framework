package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserActions;
import utilities.UIActions;

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
    public void goToDressesPage() {
        homePage.clickOnDresses();
    }


    @AfterClass
    public void tearDown() {
        BrowserActions.closeDriverAndRemoveFromMap(className);
    }
}
