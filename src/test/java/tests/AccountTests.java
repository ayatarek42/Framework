package tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignIn;
import pages.WomenPage;
import utilities.BrowserActions;

import static org.testng.Assert.assertEquals;

public class AccountTests {
    protected HomePage homePage;
    protected SignIn signInPage;
    public MyAccountPage myAccount;
    protected WomenPage womenPage;

    String className =  AccountTests.class.getName();


    @BeforeClass
    public void launchBrowser(){
        BrowserActions.initializer(className,"Chrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }

    @Test(groups = "loginGroup")
    public  void Login(){
        signInPage = homePage.clickOnSignIn();
        signInPage.enterEmailToLogin("aya42@gmail.com");
        signInPage.enterPasswordToLogin("123345");
        myAccount = signInPage.clickOnLoginButton();

    }
    @Test(dependsOnGroups = "loginGroup")
    public void goToWomen() {
        womenPage = myAccount.clickOnWomen();
    }

    @Test(dependsOnMethods = "goToWomen")
    public  void goToProfile() {

        womenPage.clickProfile();
    }

}

