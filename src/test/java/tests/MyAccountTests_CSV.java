package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignIn;
import pages.WomenPage;
import screenshot.Screenshots;
import utilities.BrowserActions;
import utilities.UIActions;

import java.io.FileReader;
import java.io.IOException;


public class MyAccountTests_CSV {
    protected HomePage homePage;
    protected SignIn signInPage;
    public MyAccountPage myAccount;
    protected WomenPage womenPage;

    String className = MyAccountTests_CSV.class.getName();


    CSVReader reader;

    @BeforeClass
    @Parameters({"browser"})
    public void launchBrowser(String browserName) {
        BrowserActions.initializer(className, browserName);
        homePage = new HomePage(className);
        homePage.navigateToHome();
    }


    @Test(groups = "loginGroup")
    public void Login() throws IOException, CsvValidationException, ParseException {
        String csv_file = System.getProperty("user.dir") + "/src/test/java/data/csv/loginData.csv";
        reader = new CSVReader(new FileReader(csv_file));
        String[] csvCell;
        while((csvCell = reader.readNext()) != null){
        String email = csvCell[0];
        String password = csvCell[1];
        signInPage = homePage.clickOnSignIn();
        signInPage.enterEmailToLogin(email);
        signInPage.enterPasswordToLogin(password);
        myAccount = signInPage.clickOnLoginButton();
        UIActions action = new UIActions(className);
        Assert.assertEquals(action.getPageTitle(),"My account - My Store");
        }
    }

    @Test(dependsOnGroups = "loginGroup")
    public void goToWomen() throws IOException, ParseException {
        womenPage = myAccount.clickOnWomen();
        UIActions action = new UIActions(className);
        Assert.assertEquals(action.getPageTitle(),"Women - My Store");
    }

    @Test(dependsOnMethods = "goToWomen")
    public void goToProfile() throws IOException, ParseException {

        womenPage.clickProfile();
        UIActions action = new UIActions(className);
        Assert.assertEquals(action.getPageTitle(),"My account - My Store");
    }

    @Test(dependsOnMethods = "goToProfile")
    public void logout() throws IOException, ParseException {
        myAccount.clickOnSignOut();
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


