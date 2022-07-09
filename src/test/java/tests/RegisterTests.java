package tests;

import data.ExcelReader;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterationPage;
import pages.SignIn;
import utilities.BrowserActions;
import utilities.UIActions;


import java.io.File;
import java.io.IOException;




public class RegisterTests{

    HomePage homePage;
    SignIn signInPage;
    MyAccountPage myAccount;
    RegisterationPage registerPage;
    String className =  RegisterTests.class.getName();

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

    @BeforeClass
    public void launchBrowser() throws IOException, ParseException {
        BrowserActions.initializer(className,"Chrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
        signInPage = homePage.clickOnSignIn();
    }

    @Test(dataProvider = "ExcelDataEmail")
    public void createAnAccount(String email) throws IOException, ParseException {
        signInPage.enterEmailToRegister(email);
        registerPage = signInPage.clickOnCreateAccount();
        UIActions action = new UIActions(className);
        action.waitForTime(30);
        //assertEquals(BrowserActions.driver.getTitle(),"Login - My Store");
    }


    @Test(dependsOnMethods = "createAnAccount")
    public void selectGender() throws IOException, ParseException {
        registerPage.selectGender();
        //assertEquals(BrowserActions.driver.findElement(By.id("id_gender2")).isSelected(),true);

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
       //assertEquals(BrowserActions.driver.getTitle(),"My account - My Store");
    }

    @AfterMethod
    public static void takeScreeshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String className = RegisterTests.class.getName();
            TakesScreenshot screenshot = (TakesScreenshot) BrowserActions.getDriver(className);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshots/" + ".png"));
        }
    }
}









