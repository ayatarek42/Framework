package pages;

import org.openqa.selenium.By;
import utilities.UIActions;


public class HomePage {

    By signIn = new By.ByCssSelector(".login");
    By dressesBtn = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    String homepageURL = "http://automationpractice.com/";
    UIActions action;
    String className;

    public HomePage(String className) {
        this.className = className;
        action = new UIActions(className);

    }

    public void navigateToHome(){
       action.navigateTo(homepageURL);
    }

    public SignIn clickOnSignIn()
    {
        action.clickOnElement(signIn);
        return new SignIn(className);
    }

    public Dresses clickOnDresses()
    {
        action.clickOnElement(dressesBtn);
        return new Dresses();
    }
}
