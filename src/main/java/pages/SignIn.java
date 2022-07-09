package pages;

import fileReaders.jsonFile.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utilities.UIActions;

import java.io.IOException;

public class SignIn{

    UIActions action;
    String className;
    JsonReader reader = new JsonReader();
    String loc = null;


    public SignIn(String className) {

        action = new UIActions(className);
        this.className = className;
    }

    public void enterEmailToRegister(String email) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(5);
        By emailField = By.id(loc);
        action.enterTextInTextField(email,emailField);
    }

    public RegisterationPage clickOnCreateAccount() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(6);
        By createAccount = By.id(loc);
        action.clickOnElement(createAccount);
        return new RegisterationPage(className);
    }

    public void enterEmailToLogin(String email) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(7);
        By authEmail = By.id(loc);
        action.enterTextInTextField(email,authEmail);

    }
    public void enterPasswordToLogin(String password) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(8);
        By authPassword = By.id(loc);
        action.enterTextInTextField(password,authPassword);

    }
    public MyAccountPage clickOnLoginButton() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(9);
        By loginButton = By.id(loc);
        action.clickOnElement(loginButton);
        return new MyAccountPage(className);
    }

}
