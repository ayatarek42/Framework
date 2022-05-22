package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void enterEmail(String email){
        action.findWebElement(emailField).sendKeys(email);

    }

    public RegisterationPage clickOnCreateAccount(){
        action.findWebElement(createAccount).click();
        return new RegisterationPage(className);
    }

    public void enterEmailToLogin(String email){
       action.findWebElement(authEmail).sendKeys(email);

    }
    public void enterPasswordToLogin(String password){
        action.findWebElement(authPassword).sendKeys(password);

    }
    public MyAccountPage clickOnLoginButton(){
        action.findWebElement(loginButton).click();
        return new MyAccountPage(className);

    }

}
