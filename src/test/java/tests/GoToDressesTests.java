package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserActions;
import utilities.UIActions;

public class GoToDressesTests {
    String className =  GoToDressesTests.class.getName();
    HomePage homePage;

    @BeforeClass
    public void launchBrowser(){
        BrowserActions.initializer(className,"Firefox");
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }


    @Test
    public void goToDressesPage(){
            homePage.clickOnDresses();
    }

}
