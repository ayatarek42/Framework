package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterationPage;
import pages.SignIn;
import utilities.BrowserActions;
import utilities.UIActions;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utilities.BrowserActions.drivers;


public class RegisterTests{
    protected HomePage homePage;
    protected SignIn signInPage;
    protected MyAccountPage myAccount;
    protected RegisterationPage registerPage;
    String className =  RegisterTests.class.getName();


    @BeforeClass
    public void launchBrowser(){
        BrowserActions.initializer(className,"Chrome");
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }

    @Test
    public void createAnAccount(){
        signInPage = homePage.clickOnSignIn();
        signInPage.enterEmail("hag@gmail.com");
        registerPage = signInPage.clickOnCreateAccount();
        //assertEquals(BrowserActions.driver.getTitle(),"Login - My Store");

        }



    @Test(dependsOnMethods = "createAnAccount")
    public void selectGender(){
        registerPage.selectGender();
        //assertEquals(BrowserActions.driver.findElement(By.id("id_gender2")).isSelected(),true);

    }

    @Test(dependsOnMethods = "selectGender")
    public void enterName(){
        registerPage.enterFirstName("Aya");
        registerPage.enterLastName("Tarek");
    }

    @Test(dependsOnMethods = "enterName")
    public void enterPassword(){
        registerPage.enterPassword("123345");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void enterDateOfBirth(){
        String dayOption ="4  ";
        registerPage.selectDayFromDropdown(dayOption);
        //assert chosen option is correct
        var selectedDayOptions = registerPage.getSelectedDropdownOptions(By.id("days"));
        //assertTrue(selectedDayOptions.contains(dayOption),"option not selected");

        String monthOption ="February ";
        registerPage.selectMonthFromDropdown(monthOption);
        var selectedMonthOptions = registerPage.getSelectedDropdownOptions(By.id("months"));
        //assertTrue(selectedMonthOptions.contains(monthOption),"option not selected");


        String yearOption ="2009  ";
        registerPage.selectYearFromDropdown(yearOption);
        var selectedYearOptions = registerPage.getSelectedDropdownOptions(By.id("years"));
        //assertTrue(selectedYearOptions.contains(yearOption),"option not selected");
    }

    @Test(dependsOnMethods = "enterDateOfBirth")
    public void enterAddressInformation(){

        registerPage.enterAddress("El Manial");
        registerPage.enterCity("Cairo");
        registerPage.selectStateFromDropdown("Alabama");
        var selectedStateOptions = registerPage.getSelectedDropdownOptions(By.id("id_state"));
        assertTrue(selectedStateOptions.contains("Alabama"),"option not selected");
        registerPage.enterPostalCode("11865");
        registerPage.selectCountryFromDropdown("United States");
        var selectedCountryOptions = registerPage.getSelectedDropdownOptions(By.id("id_country"));
        assertTrue(selectedCountryOptions.contains("United States"),"option not selected");
        registerPage.enterMobileNumber("0123456789");

    }
    @Test(dependsOnMethods = "enterAddressInformation",groups={"registerGroup"})
    public void pressRegister(){

       myAccount = registerPage.clickRegister();
        //assertEquals(BrowserActions.driver.getTitle(),"My account - My Store");
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









