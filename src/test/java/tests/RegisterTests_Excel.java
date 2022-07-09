package tests;

import data.excel.ExcelReader;
import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterationPage;
import pages.SignIn;
import screenshot.Screenshots;
import utilities.BrowserActions;
import utilities.UIActions;


import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class RegisterTests_Excel {

    HomePage homePage;
    SignIn signInPage;
    MyAccountPage myAccount;
    RegisterationPage registerPage;
    String className =  RegisterTests_Excel.class.getName();


    @BeforeClass
    public void launchBrowser() throws IOException, ParseException {
        BrowserActions.initializer(className,"Chrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
        signInPage = homePage.clickOnSignIn();
    }

    @DataProvider(name = "ExcelDataEmail")
    public Object[][] userRegisterDataEmail() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataRegistrationEmail();
    }

    @DataProvider(name = "ExcelDataName")
    public Object[][] userRegisterDataName() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataRegistrationName();
    }

    @DataProvider(name = "ExcelDataPassword")
    public Object[][] userRegisterDataPassword() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataRegistrationPassword();
    }

    @DataProvider(name = "ExcelDataDateOfBirth")
    public Object[][] userRegisterDataDateOfBirth() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataRegistrationDateOfBirth();
    }

    @DataProvider(name = "ExcelDataAddress")
    public Object[][] userRegisterDataAddress() throws IOException {
        ExcelReader exReader = new ExcelReader();
        return exReader.getExcelDataRegistrationAddress();
    }

    @Test(dataProvider = "ExcelDataEmail")
    public void createAnAccount(String email) throws IOException, ParseException {
        signInPage.enterEmailToRegister(email);
        registerPage = signInPage.clickOnCreateAccount();
        UIActions action = new UIActions(className);
        action.waitForTime(10);
        assertEquals(action.getPageTitle(),"Login - My Store");
    }


    @Test(dependsOnMethods = "createAnAccount")
    public void selectGender() throws IOException, ParseException {
       registerPage.selectGender();
    }

    @Test(dependsOnMethods = "selectGender", dataProvider = "ExcelDataName")
    public void enterName(String fname, String lname) throws IOException, ParseException {
        registerPage.enterFirstName(fname);
        registerPage.enterLastName(lname);
    }

    @Test(dependsOnMethods = "enterName", dataProvider = "ExcelDataPassword")
    public void enterPassword(String pass) throws IOException, ParseException {
        registerPage.enterPassword(pass);
    }

    @Test(dependsOnMethods = "enterPassword", dataProvider = "ExcelDataDateOfBirth")
    public void enterDateOfBirth(String day, String month, String year) throws IOException, ParseException {
        registerPage.selectDayFromDropdown(day);

        registerPage.selectMonthFromDropdown(month);

        registerPage.selectYearFromDropdown(year);

    }

    @Test(dependsOnMethods = "enterDateOfBirth", dataProvider = "ExcelDataAddress")
    public void enterAddressInformation(String address, String city, String state, String postalCode,
                                        String phone) throws IOException, ParseException {

        registerPage.enterAddress(address);
        registerPage.enterCity(city);
        registerPage.selectStateFromDropdown(state);
        registerPage.enterPostalCode(postalCode);
        registerPage.enterMobileNumber(phone);
    }

    @Test(dependsOnMethods = "enterAddressInformation",groups={"registerGroup"})
    public void pressRegister() throws IOException, ParseException {

       myAccount = registerPage.clickRegister();
       UIActions action = new UIActions(className);
       assertEquals(action.getPageTitle(),"My account - My Store");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
        Screenshots.takeScreeshot(result);
    }
}









