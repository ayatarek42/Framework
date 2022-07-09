package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignIn;
import utilities.BrowserActions;
import utilities.UIActions;

import java.io.IOException;

public class TestHeadlessChrome {

    String className = TestHeadlessPhantomJs.class.getName();
    HomePage homePage;
    SignIn signInPage;

    @BeforeClass
    public void launchBrowser() throws IOException, ParseException {
        BrowserActions.initializer(className,"headlessChrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
        signInPage = homePage.clickOnSignIn();
    }


    @Test
    public void test1() {
        UIActions act = new UIActions(className);
        act.navigateTo("https://www.google.com/");
    }
    @Test
    public void test2() {
        UIActions act = new UIActions(className);
        act.navigateTo("https://www.facebook.com/");
    }

}
