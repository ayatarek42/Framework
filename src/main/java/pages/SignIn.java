package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import utilities.BrowserActions;
import utilities.UIActions;

public class SignIn{

    By emailField = By.id("email_create");
    By createAccount = By.xpath("//button[@id=\"SubmitCreate\"]");
    By authEmail = By.id("email");
    By authPassword = By.id("passwd");
    By loginButton = By.id("SubmitLogin");
    UIActions action;
    String className;

    public SignIn(String className) {

        action = new UIActions(className);
        this.className = className;
    }

    public void enterEmailToRegister(String email){
        action.enterTextInTextField(email,emailField);
    }

    public RegisterationPage clickOnCreateAccount(){
        action.clickOnElement(createAccount);
        return new RegisterationPage(className);
    }

    public void enterEmailToLogin(String email){
       action.enterTextInTextField(email,authEmail);

    }
    public void enterPasswordToLogin(String password){
        action.enterTextInTextField(password,authPassword);

    }
    public MyAccountPage clickOnLoginButton(){
        action.clickOnElement(loginButton);
        return new MyAccountPage(className);
    }

}
