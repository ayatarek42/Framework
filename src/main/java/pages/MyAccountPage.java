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
            action.clickOnElement(women);
            return new WomenPage(className);
        }
}
