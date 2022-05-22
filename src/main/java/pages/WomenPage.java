package pages;

import org.openqa.selenium.By;
import utilities.BrowserActions;
import utilities.UIActions;

public class WomenPage{

    By profile = By.xpath("//a[@title=\"View my customer account\"]");
    UIActions action;
    String className;

    public WomenPage(String className) {
        action = new UIActions(className);
        this.className = className;
    }

    public void clickProfile(){
        action.findWebElement(profile).click();
    }


}
