package stepDefinitions;

import data.excel.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterationPage;
import pages.SignIn;
import runner.TestRunner;
import utilities.BrowserActions;
import utilities.UIActions;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Registration extends TestRunner {

    MyAccountPage myAccount;
    RegisterationPage registerPage;
    HomePage homePage;
    SignIn signInPage;
    String className = TestRunner.class.getName();

    @Given("The user in the sign in page")
    @BeforeClass
    public void launchBrowser() throws IOException, ParseException {
        BrowserActions.initializer(className,"Firefox");
        homePage = new HomePage(className);
        homePage.navigateToHome();
        signInPage = homePage.clickOnSignIn();
    }


    @When("I enter {string}")
    public void createAnAccount(String email) throws IOException, ParseException {
        signInPage.enterEmailToRegister(email);
        registerPage = signInPage.clickOnCreateAccount();
        UIActions action = new UIActions(className);
        action.waitForTime(10);
        assertEquals(action.getPageTitle(),"Login - My Store");
    }

    @When("I enter the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}")
    public void enterUserData(String fname, String lname, String password, String day, String month,
                              String year, String address, String city, String state,
                              String postalCode, String phone) throws IOException, ParseException {
        registerPage.selectGender();
        registerPage.enterFirstName(fname);
        registerPage.enterLastName(lname);
        registerPage.enterPassword(password);
        registerPage.selectDayFromDropdown(day);
        registerPage.selectMonthFromDropdown(month);
        registerPage.selectYearFromDropdown(year);
        registerPage.enterAddress(address);
        registerPage.enterCity(city);
        registerPage.selectStateFromDropdown(state);
        registerPage.enterPostalCode(postalCode);
        registerPage.enterMobileNumber(phone);
    }


    @When("I click on register button")
    public void pressRegister() throws IOException, ParseException {
        myAccount = registerPage.clickRegister();
    }

    @Then("User is registered successfully")
    public void assertOnMyAccountPageAfterRegistration()
    {
        UIActions action = new UIActions(className);
        assertEquals(action.getPageTitle(),"My account - My Store");
    }
}
