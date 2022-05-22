package pages;

import org.openqa.selenium.By;
import utilities.UIActions;

public class MyAccountPage {

       By women = By.linkText("Women");
       UIActions action ;
       String className;

    public MyAccountPage(String className) {
        this.className = className;
        action = new UIActions(className);

    }
    public WomenPage clickOnWomen(){
            action.findWebElement(women).click();
            return new WomenPage(className);
        }
}
